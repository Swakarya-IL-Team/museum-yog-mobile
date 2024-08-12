package com.swakarya.museumyog.data.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swakarya.museumyog.data.local.entity.TransportInfo

class TransportInfoConverter {

    @TypeConverter
    fun fromTransportInfoList(value: List<TransportInfo>): String {
        val gson = Gson()
        val type = object : TypeToken<List<TransportInfo>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toTransportInfoList(value: String): List<TransportInfo> {
        val gson = Gson()
        val type = object : TypeToken<List<TransportInfo>>() {}.type
        return gson.fromJson(value, type)
    }
}