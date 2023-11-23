package com.example.pixabay

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://pixabay.com/api/

object RetrofitService {

    val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api = retrofit.create(PixaApi::class.java)
}