package com.example.innobuzzdemo.RoomDataBase

import android.content.Context
import androidx.room.Room

object DataBaseBuilder {
    private var INSTANCE: DataBase? = null
    fun getInstance(context: Context): DataBase {
        if (INSTANCE == null) {
            synchronized(DataBase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }
    private fun buildRoomDB(context: Context) = Room.databaseBuilder(context.applicationContext, DataBase::class.java, "InnoBuzzDataBase").build()
}