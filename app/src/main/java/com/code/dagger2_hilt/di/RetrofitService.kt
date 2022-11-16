package com.code.dagger2_hilt.di

import com.code.dagger2_hilt.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("repositories")
    fun getDataFromAPI(@Query(value="q")query:String):Call<RecyclerList>?
}