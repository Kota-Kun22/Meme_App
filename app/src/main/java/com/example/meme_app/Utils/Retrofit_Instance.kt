package com.example.meme_app.Utils

import com.example.meme_app.Data.Api_Interface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofit_Instance {
    val api: Api_Interface by lazy {
        Retrofit.Builder()
            .baseUrl(Utils.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api_Interface::class.java)

    }
}