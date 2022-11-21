package com.code.dagger2_hilt.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import javax.inject.Singleton

@Module
class RetrofitModule {
    private val baseUrl = "https://api.github.com/search/"//repositories?q=newyork

    @Singleton
    @Provides
    fun getRetrofitService(retrofit: Retrofit): RetrofitService =
        retrofit.create(RetrofitService::class.java)

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
        .client(client())
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private fun client(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor())
        .callTimeout(60, TimeUnit.MILLISECONDS)
        .readTimeout(60, TimeUnit.MILLISECONDS)
        .writeTimeout(60, TimeUnit.MILLISECONDS)
        .connectTimeout(60, TimeUnit.MILLISECONDS)
        .build()

    fun interceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

}