package com.example.LeVanTai_18093421_Roomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int imgEdit;
    private int imgDelete;

    public int getImgEdit() {
        return imgEdit;
    }

    public void setImgEdit(int imgEdit) {
        this.imgEdit = imgEdit;
    }

    public int getImgDelete() {
        return imgDelete;
    }

    public void setImgDelete(int imgDelete) {
        this.imgDelete = imgDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
    }

    public User(String name, int imgEdit, int imgDelete) {
        this.name = name;
        this.imgEdit = imgEdit;
        this.imgDelete = imgDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
