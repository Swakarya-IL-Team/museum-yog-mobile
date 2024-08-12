package com.swakarya.museumyog.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.swakarya.museumyog.data.local.entity.Museum

@Dao
interface MuseumDao {
    @Query("SELECT * FROM museums")
    suspend fun getAllMuseums(): List<Museum>

    @Query("SELECT * FROM museums WHERE id = :id")
    suspend fun getMuseumById(id: Int): Museum?

    @Insert
    suspend fun insertMuseums(museums: List<Museum>)


}