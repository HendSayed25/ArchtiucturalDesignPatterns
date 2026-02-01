package com.example.archtiucturaldesign.data.db;

import static com.example.archtiucturaldesign.data.products.datasource.util.Constants.PRODUCT_DATABASE_NAME;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.archtiucturaldesign.data.products.datasource.local.ProductDao;
import com.example.archtiucturaldesign.data.products.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if(instance == null) {
            synchronized (AppDatabase.class){
                instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, PRODUCT_DATABASE_NAME).build();
            }
        }
        return instance;
    }
}