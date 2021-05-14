package com.example.LeVanTai_18093421_Roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoUser {

    @Insert
    void InsertUser(User user);

    @Query("SELECT * FROM user")
     List<User> getList();

    @Delete
    void DeleteUser(User user);

    @Update
    void UpdateUser(User user);
}
