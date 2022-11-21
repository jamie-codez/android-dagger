package com.code.dagger2_hilt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.code.dagger2_hilt.model.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insert(userEntity: UserEntity)
    @Query("select * from user_entity order by id desc")
    suspend fun selectAll():List<UserEntity>
}