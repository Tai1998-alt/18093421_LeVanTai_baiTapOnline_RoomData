package com.example.LeVanTai_18093421_Roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class DatabaseUser extends RoomDatabase {
    private static final String DATABASE_NAME="dataUser.db";
    private static DatabaseUser instance;
    public static synchronized DatabaseUser getInstance(Context context)
    {
        if(instance==null)
        {
                instance = Room.databaseBuilder(context.getApplicationContext(),DatabaseUser.class,DATABASE_NAME)
                        .allowMainThreadQueries().build();

        }
        return instance;
    }

    public abstract DaoUser daoUser();
}
