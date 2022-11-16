package com.code.dagger2_hilt

import android.app.Application
import com.code.dagger2_hilt.di.DaggerRetrofitComponent
import com.code.dagger2_hilt.di.RetrofitComponent
import com.code.dagger2_hilt.di.RetrofitModule

class MyApplication:Application() {
    private lateinit var retrofitComponent: RetrofitComponent
    override fun onCreate() {
        super.onCreate()
        retrofitComponent = DaggerRetrofitComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()
    }
    fun getRetrofitComponent():RetrofitComponent = retrofitComponent
}