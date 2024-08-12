package com.swakarya.museumyog.data.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swakarya.museumyog.data.local.entity.EventInfo

class EventInfoConverter {

    @TypeConverter
    fun fromEventInfoList(value: List<EventInfo>): String {
        val gson = Gson()
        val type = object : TypeToken<List<EventInfo>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toEventInfoList(value: String): List<EventInfo> {
        val gson = Gson()
        val type = object : TypeToken<List<EventInfo>>() {}.type
        return gson.fromJson(value, type)
    }
}