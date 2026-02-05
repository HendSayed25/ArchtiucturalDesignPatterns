package com.example.archtiucturaldesign.data.products.datasource.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.archtiucturaldesign.data.db.AppDatabase;
import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public class ProductLocalDataSource {
    private ProductDao productDao;

    public ProductLocalDataSource(Context context) {
        productDao = AppDatabase.getInstance(context).productDao();
    }

    public Flowable<List<Product>> getAllFavProducts() {
        return productDao.getAllProducts();
    }

    public Completable addToFav(Product product) {
        return productDao.addToFav(product);
    }

    public Completable deleteFromFav(Product product) {
        return productDao.deleteFromFav(product);
    }
}