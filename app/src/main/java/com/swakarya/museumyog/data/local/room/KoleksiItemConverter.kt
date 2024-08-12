package com.swakarya.museumyog.data.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swakarya.museumyog.data.local.entity.KoleksiItem

class KoleksiItemConverter {

    @TypeConverter
    fun fromKoleksiItemList(value: List<KoleksiItem>): String {
        val gson = Gson()
        val type = object : TypeToken<List<KoleksiItem>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toKoleksiItemList(value: String): List<KoleksiItem> {
        val gson = Gson()
        val type = object : TypeToken<List<KoleksiItem>>() {}.type
        return gson.fromJson(value, type)
    }
}