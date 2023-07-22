package com.example.rmimdatabase.Serviec;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.rmimdatabase.Model.Image;

import java.util.List;

@Dao
public interface DTO {

    @Insert
    void insertImage(Image image);

    @Query("SELECT * FROM Image")
    List<Image>getAllImages();
}
