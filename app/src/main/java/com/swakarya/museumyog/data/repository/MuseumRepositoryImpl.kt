package com.swakarya.museumyog.data.repository

import com.swakarya.museumyog.data.local.entity.Museum
import com.swakarya.museumyog.data.local.room.MuseumDao
import com.swakarya.museumyog.domain.repository.MuseumRepository
import javax.inject.Inject

class MuseumRepositoryImpl @Inject constructor(
    private val museumDao: MuseumDao
) : MuseumRepository {
    override suspend fun getMuseums(): List<Museum> = museumDao.getAllMuseums()
    override suspend fun getMuseumById(id: Int): Museum? = museumDao.getMuseumById(id)
}