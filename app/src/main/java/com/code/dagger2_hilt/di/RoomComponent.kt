package com.code.dagger2_hilt.di

import com.code.dagger2_hilt.RoomViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomModule::class])
interface RoomComponent {
    fun injectRoomMainViewModel(roomViewModel: RoomViewModel)
}