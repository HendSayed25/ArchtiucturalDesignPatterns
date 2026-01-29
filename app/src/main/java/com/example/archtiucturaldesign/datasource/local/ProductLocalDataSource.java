package com.example.archtiucturaldesign.datasource.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.archtiucturaldesign.db.AppDatabase;
import com.example.archtiucturaldesign.model.Product;

import java.util.List;

public class ProductLocalDataSource {
    private ProductDao productDao;

   public ProductLocalDataSource(Context context) {
       productDao = AppDatabase.getInstance(context).productDao();
   }

   public LiveData<List<Product>> getAllFavProducts() {
       return productDao.getAllProducts();
   }

   public void addToFav(Product product) {
       new Thread(() -> {
           productDao.addToFav(product);
       }).start();
   }

   public void deleteFromFav(Product product) {
       new Thread(() -> {
           productDao.deleteFromFav(product);
       }).start();
   }
}