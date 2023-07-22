package com.example.rmimdatabase.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.rmimdatabase.Model.Image;
import com.example.rmimdatabase.Serviec.DTO;
import com.example.rmimdatabase.SupprotClass.ImageBitmap;

@Database(entities = {Image.class},version = 1)
@TypeConverters(ImageBitmap.class)
public abstract class DatabaseClient extends RoomDatabase{


    public abstract DTO getDto();


    public static DatabaseClient databaseClient =null;


    public static DatabaseClient database(Context context){
        if (databaseClient==null){

            databaseClient= Room.databaseBuilder(context
                            .getApplicationContext(),DatabaseClient.class,"image_table")
                    .allowMainThreadQueries().build();
        }




  return databaseClient;

    }



}
