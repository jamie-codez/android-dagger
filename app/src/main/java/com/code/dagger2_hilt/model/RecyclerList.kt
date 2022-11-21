package com.code.dagger2_hilt.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class RecyclerList(val items: List<RecyclerData>)
data class RecyclerData(val name: String?, val description: String?, val owner: Owner?)
data class Owner(val avatar_url: String?)

@Entity(tableName = "user_entity")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "description") val description: String
)