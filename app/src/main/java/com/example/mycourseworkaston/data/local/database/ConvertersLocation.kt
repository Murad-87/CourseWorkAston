package com.example.mycourseworkaston.data.local.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//class ConvertersLocation {
//
//    @TypeConverter
//    fun fromString(value: String): List<String>{
//
//        val listTypeLocation = object : TypeToken<List<String>>(){}.type
//        return Gson().fromJson(value, listTypeLocation)
//    }
//
//    @TypeConverter
//    fun toStringLocation(list: List<String>): String {
//        return Gson().toJson(list)
//    }
//}