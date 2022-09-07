package com.demo.db_room.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.demo.db_room.Interface.UserDao;
import com.demo.db_room.Modelo.Usuario;
import com.demo.db_room.Modelo.Converter;

@Database(entities = {Usuario.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
