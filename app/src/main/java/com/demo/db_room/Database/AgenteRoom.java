package com.demo.db_room.Database;

import android.content.Context;

import androidx.room.Room;

import com.demo.db_room.Interface.UserDao;

public class AgenteRoom {

    public static UserDao userDao;
    public static AppDataBase room;

    public synchronized static UserDao getRoom(Context context) {
        if (userDao == null) {
            room = Room
                    .databaseBuilder(context, AppDataBase.class, "users")
                    .build();

            userDao = room.userDao();
        }
        return userDao;
    }
}
