package com.example.LeVanTai_18093421_Roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoUser {
    @Insert
    void InsertUser(User user);

    @Query("SELECT * FROM user")
     List<User> getList();
}
