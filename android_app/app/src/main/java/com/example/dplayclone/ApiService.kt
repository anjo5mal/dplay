package com.example.dplayclone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {
    @GET("api/channels.php?action=list")
    fun getChannels(): Call<List<Channel>>
}

object ApiClient {
    private const val BASE = "https://your-server.example/" // <-- change to your server
    val apiService: ApiService = Retrofit.Builder()
        .baseUrl(BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}
