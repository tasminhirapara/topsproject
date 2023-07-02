package com.example.topsproject.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.topsproject.Interface.Apiinterface
import com.example.topsproject.Model.RegisterModel
import com.example.topsproject.R
import com.example.topsproject.client.Apiclient
import com.example.topsproject.databinding.ActivityLoginBinding
import com.example.topsproject.databinding.ActivitySplashScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedpreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =  ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedpreferences= getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
//            if (sharedpreferences.getBoolean("USER_SESSION",false) && sharedpreferences.getString("PHONE","")!!
//                    .isNotEmpty())
//            {
//                startActivity(Intent(this, homeActivity::class.java))
//                finish()
//            }


        binding.btnLogIn.setOnClickListener {

            var phone =  binding.edtphone.text.toString()
            var pass = binding.edtPassword.text.toString()

            apiinterface = Apiclient.getretofit()!!.create(Apiinterface::class.java)

            var call: Call<RegisterModel> =  apiinterface.logindata(phone,pass)
            call.enqueue(object : Callback<RegisterModel>
            {
                override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>)

                {
                  Toast.makeText(applicationContext,"success",Toast.LENGTH_LONG).show()
                    var edit:SharedPreferences.Editor = sharedpreferences.edit()
                    edit.putString("PHONE",phone)
                    edit.putString("PASS",pass)
                    edit.putBoolean("USER_SESSION",true)
                    edit.commit()

                    startActivity(Intent(applicationContext,homeActivity::class.java))
                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"fail",Toast.LENGTH_LONG).show()
                }
            })
        }

        binding.textViewregisterlink.setOnClickListener()
        {

            startActivity(Intent(applicationContext,SignupActivity::class.java))
        }


    }

    override fun onBackPressed() {

        finishAffinity()
    }
}