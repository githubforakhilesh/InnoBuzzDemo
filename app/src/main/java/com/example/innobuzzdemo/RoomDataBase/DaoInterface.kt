package com.example.innobuzzdemo.RoomDataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoInterface {

    @Query("SELECT * FROM Entity")
     fun getAll(): LiveData<List<Entity>>

    @Insert
   suspend fun insertAll(ItemsList: List<Entity>)
}