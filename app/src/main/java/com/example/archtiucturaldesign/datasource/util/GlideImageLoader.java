package com.example.archtiucturaldesign.datasource.util;



import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.archtiucturaldesign.R;

public class GlideImageLoader {

    private GlideImageLoader() {}

    public static void load(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).placeholder(R.drawable.placeholder).into(imageView);
    }
}