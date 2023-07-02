package com.example.topsproject.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient {

    companion object {

        var BASE_URL = "https://tasmin123.000webhostapp.com/topsproject/"
        var retrofit: Retrofit? = null
        fun getretofit(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }


            return retrofit


        }
    }
}