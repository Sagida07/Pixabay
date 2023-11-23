package com.example.pixabay

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// https://pixabay.com/api/

interface PixaApi {

    @GET("api/")
    fun getImages(
        @Query("key") key: String = "40848451-68bea421d5f63191ab5d53e3b",
        @Query("q") keyWord: String,
        @Query("per_page") perPage: Int = 3,
        @Query("page") page: Int = 1
    ): Call<PixaModel>
}