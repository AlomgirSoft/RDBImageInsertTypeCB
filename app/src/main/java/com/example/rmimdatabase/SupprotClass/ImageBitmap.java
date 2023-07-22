package com.example.rmimdatabase.SupprotClass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;

public class ImageBitmap {
@TypeConverter
public static byte [] getImageFormatBitmap(Bitmap bitmapPicture){
    if (bitmapPicture == null) {
        return null;
    }
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    bitmapPicture.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
   return  byteArrayOutputStream.toByteArray();


}


public static Bitmap bitmap(byte []array){
    if (array == null) {
        return null;
    }
    return BitmapFactory.decodeByteArray(array,0,array.length);

}



//
//    public static byte[] compressImage(byte[] imageToCompress) {
//
//         byte []  compressImage= imageToCompress;
//
//        while (compressImage.length > 500000 && 100 > 10) {
//            Bitmap bitmap = BitmapFactory.decodeByteArray(compressImage, 0, compressImage.length);
//
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            compressImage = stream.toByteArray();
//
//
//        }
//
//        return compressImage;
//    }

}
