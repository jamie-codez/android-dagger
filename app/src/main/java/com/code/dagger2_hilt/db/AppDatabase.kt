package com.code.dagger2_hilt.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.code.dagger2_hilt.model.UserEntity
import dagger.Provides
import javax.inject.Singleton

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getUserDao():UserDao
    companion object {
        private var database: AppDatabase? = null
        fun getDatabaseInstance(context: Context): AppDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "app_db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!
        }
    }
}
