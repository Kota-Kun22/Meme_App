package com.example.meme_app.Data

import com.example.meme_app.Models.Meme
import retrofit2.http.GET

interface Api_Interface {
    @GET("get_memes")
    suspend fun getALLMemesList() :Result<Meme>
}