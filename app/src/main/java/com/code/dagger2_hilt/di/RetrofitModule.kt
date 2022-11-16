package com.code.dagger2_hilt.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    private val baseUrl = "https://api.github.com/search/"//repositories?q=newyork

    @Singleton
    @Provides
    fun getRetrofitService(retrofit: Retrofit):RetrofitService = retrofit.create(RetrofitService::class.java)

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}