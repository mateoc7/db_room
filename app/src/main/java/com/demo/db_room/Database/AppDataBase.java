package com.demo.db_room.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.demo.db_room.Interface.UserDao;
import com.demo.db_room.Modelo.Usuario;

@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
