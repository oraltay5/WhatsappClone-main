package com.example.whatsappclone.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

//    @GET("anime")
//    fun getAnimeList(): Call<AnimeListDTO>

    //------------------------------------------------------------------------------------------
//    @GET("v3/articles")
//    fun getAnimeList(): Call<AnimeListDTO>

    //------------------------------------------------------------------------------------------

    @GET("users")
    fun getAnimeList(): Call<AnimeListDTO>

    @POST("auth/login")
    fun auth(@Body authDTO: AuthDTO): UsersDTO
//    fun auth(@Body authDTO: AuthDTO): Call<UsersDTO>
}