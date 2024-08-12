package com.swakarya.museumyog.data.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swakarya.museumyog.data.local.entity.FasilitasInfo

class FasilitasInfoConverter {

    @TypeConverter
    fun fromFasilitasInfoList(value: List<FasilitasInfo>): String {
        val gson = Gson()
        val type = object : TypeToken<List<FasilitasInfo>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toFasilitasInfoList(value: String): List<FasilitasInfo> {
        val gson = Gson()
        val type = object : TypeToken<List<FasilitasInfo>>() {}.type
        return gson.fromJson(value, type)
    }
}