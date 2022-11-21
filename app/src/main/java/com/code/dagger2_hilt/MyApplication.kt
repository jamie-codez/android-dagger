package com.code.dagger2_hilt

import android.app.Application
import com.code.dagger2_hilt.di.*

class MyApplication:Application() {
    private lateinit var retrofitComponent: RetrofitComponent
    private lateinit var roomComponent: RoomComponent
    override fun onCreate() {
        super.onCreate()
        retrofitComponent = DaggerRetrofitComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()
        roomComponent = DaggerRoomComponent.builder()
            .roomModule(RoomModule(this))
            .build()
    }
    fun getRetrofitComponent():RetrofitComponent = retrofitComponent
    fun getRoomDBComponent():RoomComponent = roomComponent
}