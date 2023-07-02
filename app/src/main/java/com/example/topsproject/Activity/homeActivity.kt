package com.example.topsproject.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.topsproject.Adapter.HomeAdapter
import com.example.topsproject.Interface.Apiinterface
import com.example.topsproject.Model.HomeModel
import com.example.topsproject.R
import com.example.topsproject.client.Apiclient
import com.example.topsproject.databinding.ActivityHomeBinding
import com.example.topsproject.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class homeActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var list: MutableList<HomeModel>
    lateinit var apiinterface : Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =   ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION",Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"welcome" + sharedPreferences.getString("PHONE",""),Toast.LENGTH_LONG).show()

        list = ArrayList()

        binding.recycler.layoutManager = GridLayoutManager(this,2)

        apiinterface = Apiclient.getretofit()!!.create(Apiinterface::class.java)
        var call: Call<List<HomeModel>> =  apiinterface.viewData()
        call.enqueue(object : Callback<List<HomeModel>> {
            override fun onResponse(call: Call<List<HomeModel>>, response: Response<List<HomeModel>>, )
            {
                list  = response.body() as MutableList<HomeModel>
                var adapter = HomeAdapter(applicationContext,list)
                binding.recycler.adapter=adapter
            }

            override fun onFailure(call: Call<List<HomeModel>>, t: Throwable)
            {
                Toast.makeText(applicationContext,""+t.message,Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed()
    {
        finishAffinity()
    }
}