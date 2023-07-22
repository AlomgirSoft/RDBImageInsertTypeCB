package com.example.rmimdatabase.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rmimdatabase.Database.DatabaseClient;
import com.example.rmimdatabase.Model.Image;
import com.example.rmimdatabase.R;
import com.example.rmimdatabase.SupprotClass.ImageBitmap;
import com.example.rmimdatabase.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    Button button;
 ;
    View view;
    Bitmap bitmap =null;
    int SELECT_PICTURE = 200;
    private ArrayList<Object> bitmaps;
    byte[] imageSources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.galary.setOnClickListener(v->{
         loadImagesFormatGallery();
        });
        binding.save.setOnClickListener(v->{
            Image image = new Image();
            image.setImages(ImageBitmap.getImageFormatBitmap(bitmap));
            DatabaseClient.database(getApplicationContext()).getDto().insertImage(image);


        });

        binding.getBtn.setOnClickListener(v->{
          //  startActivity(new Intent(MainActivity.this, ImageRecActivity.class));
            Intent intent = new Intent(MainActivity.this,ImageRecActivity.class);
            startActivityForResult(intent,0);
        });
        binding.imageView2.setOnClickListener(v->{

        });


    }

//    public void upload(View view) {
//        loadImagesFormatGallery();
//    }


//    public void save(View view) {
//        Image image = new Image();
//        image.setImages(ImageBitmap.getImageFormatBitmap(bitmap));
//        DatabaseClient.database(getApplicationContext()).getDto().insertImage(image);
//
//    }

//    public void get(View view) {
//        startActivity(new Intent(MainActivity.this, ImageRecActivity.class));
//    }


    public void loadImagesFormatGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select picture"), SELECT_PICTURE);

    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            if (requestCode==SELECT_PICTURE){
                Uri selectedImageUri= data.getData();
                if (null!=selectedImageUri){
                binding.imageView2.setImageURI(selectedImageUri);
                    try {
                        bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImageUri);
                        binding.imageView2.setImageBitmap(bitmap);

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
