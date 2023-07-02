package com.example.topsproject.Interface

import com.example.topsproject.Model.HomeModel
import com.example.topsproject.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Apiinterface
{
    @FormUrlEncoded
    @POST("signup.php")
    fun registerdata
                (
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("gender") gender:String?,
        @Field("email") email: String?,
        @Field("phone") mobile: String?,
        @Field("password") password: String?,
    ): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata (

        @Field("phone") mobile: String?,
        @Field("pass") password : String?,
    ): Call<RegisterModel>

    @GET("category.php")
    fun viewData(): Call<List<HomeModel>>
}