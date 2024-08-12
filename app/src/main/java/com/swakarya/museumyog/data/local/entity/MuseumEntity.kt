package com.swakarya.museumyog.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "museums")
data class Museum(
    @PrimaryKey val id: Int,
    val name: String,
    val imageList: List<Int>,
    val range: String,
    val place: String,
    val rate: String,
    val visitor: String,
    val description: String,
    val address: String,
    val phone: String,
    val openingHours: String,
    val transportInfo: List<TransportInfo>,
    val fasilitasInfo: List<FasilitasInfo>,
    val eventInfo: List<EventInfo>,
    val koleksi: List<KoleksiItem>,
    val reviews: List<Review>
)
