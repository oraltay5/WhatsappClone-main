package com.example.whatsappclone.network


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


fun createApplicationService(baseUrl: String): ApiServices{
    val headerInterceptor = HeaderInterceptor()
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(headerInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    return retrofit.create(ApiServices::class.java)
}


//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//class ApiClient {
//
//    companion object{
////        const val BASE_URL = "https://kitsu.io/api/edge/"
////        const val BASE_URL = "https://api.spaceflightnewsapi.net/"
//        const val BASE_URL = "https://dummyjson.com/"
//    }
//
//    private var retrofit: Retrofit? = null
//
//    fun getClient(): Retrofit? {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//        retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//        return retrofit
//    }
//
////    fun getUserAuth(): Retrofit? {
////        retrofit = Retrofit.Builder()
////            .baseUrl(BASE_URL)
//////            .baseUrl("https://api.spaceflightnewsapi.net/")
//////            .baseUrl("https://kitsu.io/api/edge/")
////            .addConverterFactory(GsonConverterFactory.create())
////            .build()
////        return retrofit
////    }
//}