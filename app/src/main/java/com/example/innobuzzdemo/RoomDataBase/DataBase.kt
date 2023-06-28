package com.example.innobuzzdemo.RoomDataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun itemDao(): DaoInterface

}