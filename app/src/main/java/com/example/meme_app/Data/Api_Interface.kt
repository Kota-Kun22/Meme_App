package com.example.meme_app.Data

import com.example.meme_app.Models.All_Meme_data
import com.example.meme_app.Models.Meme
import retrofit2.Response
import retrofit2.http.GET

interface Api_Interface {
    @GET("get_memes")
    suspend fun getALLMemesList() : Response<All_Meme_data>
    /**
     * here musing the GET annotation
     * and making a suspend fucntion  which return a Response<>
     * and in the get annotation i will set the END POINTS

     * */
}