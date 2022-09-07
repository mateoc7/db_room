package com.demo.db_room.Modelo;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Converter {

    @TypeConverter
    public static String listToString(String[] list) {
        Gson gson = new Gson();
        Type type = new TypeToken<String[]>() {}.getType();
        return gson.toJson(list, type);
    }

    @TypeConverter
    public static String[] stringToList(String value) {
        Gson gson = new Gson();
        Type type = new TypeToken<String[]>() {}.getType();
        return gson.fromJson(value, type);
    }

}