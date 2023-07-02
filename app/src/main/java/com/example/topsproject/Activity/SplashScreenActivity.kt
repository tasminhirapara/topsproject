package com.example.topsproject.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.topsproject.R
import com.example.topsproject.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    lateinit var sharedpreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Handler().postDelayed(Runnable {
            sharedpreferences= getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
            if (sharedpreferences.getBoolean("USER_SESSION",false) && sharedpreferences.getString("PHONE","")!!
                    .isNotEmpty())
            {
                startActivity(Intent(this, homeActivity::class.java))
                finish()
            }
            else
            {
                startActivity(Intent(application, LoginActivity::class.java))
            }
        },4000)


    }
}