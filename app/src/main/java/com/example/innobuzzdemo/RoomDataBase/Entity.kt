package com.example.innobuzzdemo.RoomDataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "Title") val title: String?,
    @ColumnInfo(name = "UserID") val userId: Int?,
    @ColumnInfo(name = "Body") val body: String?
    )
