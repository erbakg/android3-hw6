package com.example.android3_hw6
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun getImages(@Query("limit") limit: Int) : Call<List<CatImage>>
}