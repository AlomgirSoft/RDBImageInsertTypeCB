package com.example.rmimdatabase.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.rmimdatabase.Adapter.ImageAdapter;
import com.example.rmimdatabase.Database.DatabaseClient;
import com.example.rmimdatabase.Model.Image;
import com.example.rmimdatabase.R;
import com.example.rmimdatabase.databinding.ActivityImageRecBinding;

import java.util.List;

public class ImageRecActivity extends AppCompatActivity {
  private ActivityImageRecBinding binding;

  private List<Image>images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityImageRecBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    images=    DatabaseClient.database(ImageRecActivity.this).getDto().getAllImages();

        ImageAdapter adapter = new ImageAdapter(ImageRecActivity.this,images);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());

         binding.recyclerView.setAdapter(adapter);


    }
}