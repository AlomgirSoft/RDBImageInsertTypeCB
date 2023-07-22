package com.example.rmimdatabase.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Image {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "image_id")
    private int id;



    public byte [] getImages(){
        return images;
    }


    public void setImages(byte[] images) {
        this.images = images;
    }

    @ColumnInfo(name = "image_list",typeAffinity = ColumnInfo.BLOB)
    private byte[]images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
