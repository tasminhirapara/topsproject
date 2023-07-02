package com.example.topsproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.topsproject.Interface.Apiinterface
import com.example.topsproject.R
import com.example.topsproject.databinding.ActivityCategoryBinding
import com.example.topsproject.databinding.ActivityLoginBinding

class CategoryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryBinding
    lateinit var apiinterface: Apiinterface
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =  ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var i = intent
        Toast.makeText(applicationContext,""+i.getIntExtra("position",111), Toast.LENGTH_LONG).show()
        var pos = i.getIntExtra("position",111)



    }
}