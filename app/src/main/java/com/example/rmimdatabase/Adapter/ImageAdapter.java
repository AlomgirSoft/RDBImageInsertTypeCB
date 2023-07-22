package com.example.rmimdatabase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rmimdatabase.Model.Image;
import com.example.rmimdatabase.R;
import com.example.rmimdatabase.SupprotClass.ImageBitmap;
import com.example.rmimdatabase.databinding.ItemImageBinding;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
 private Context context;
 private List<Image>imageList;

    public ImageAdapter(Context context, List<Image> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        Image image =imageList.get(position);
        holder.binding.imageView.setImageBitmap(ImageBitmap.bitmap(image.getImages()));
        image.setImages(image.getImages());

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
       ItemImageBinding binding;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ItemImageBinding.bind(itemView);
        }
    }
}
