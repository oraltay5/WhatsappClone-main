package com.example.whatsappclone.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("anime")
    fun getAnimeList(): Call<AnimeListDTO>
}