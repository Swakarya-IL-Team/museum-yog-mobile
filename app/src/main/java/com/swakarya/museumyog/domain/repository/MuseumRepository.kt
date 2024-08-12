package com.swakarya.museumyog.domain.repository

import com.swakarya.museumyog.data.local.entity.Museum

interface MuseumRepository {
    suspend fun getMuseums(): List<Museum>
    suspend fun getMuseumById(id: Int): Museum?
}