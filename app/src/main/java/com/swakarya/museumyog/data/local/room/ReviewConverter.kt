package com.swakarya.museumyog.data.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swakarya.museumyog.data.local.entity.Review

class ReviewConverter {
    @TypeConverter
    fun fromReviewList(reviews: List<Review>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Review>>() {}.type
        return gson.toJson(reviews, type)
    }

    @TypeConverter
    fun toReviewList(reviewString: String): List<Review> {
        val gson = Gson()
        val type = object : TypeToken<List<Review>>() {}.type
        return gson.fromJson(reviewString, type)
    }
}