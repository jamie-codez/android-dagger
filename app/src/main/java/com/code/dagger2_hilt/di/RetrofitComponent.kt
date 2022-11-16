package com.code.dagger2_hilt.di

import com.code.dagger2_hilt.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {
    fun inject(mainViewModel: MainViewModel)
}