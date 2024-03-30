package com.example.meme_app.Data

import com.example.meme_app.Models.All_Meme_data
import com.example.meme_app.Models.Meme
import retrofit2.Response
import retrofit2.http.GET

interface Api_Interface {
    @GET("get_memes")
    suspend fun getALLMemesList() : Response<All_Meme_data>
}