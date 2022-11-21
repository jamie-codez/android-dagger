package com.code.dagger2_hilt.di

import android.app.Application
import android.content.Context
import com.code.dagger2_hilt.MyApplication
import com.code.dagger2_hilt.db.AppDatabase
import com.code.dagger2_hilt.db.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val application: Application) {
    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDao = appDatabase.getUserDao()

    @Singleton
    @Provides
    fun getRoomDatabaseInstance(): AppDatabase =
        AppDatabase.getDatabaseInstance(provideAppContext())

    @Singleton
    @Provides
    fun provideAppContext(): Context = application.applicationContext
}