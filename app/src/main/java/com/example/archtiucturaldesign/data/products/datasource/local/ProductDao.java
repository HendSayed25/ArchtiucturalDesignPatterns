package com.example.archtiucturaldesign.data.products.datasource.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.archtiucturaldesign.data.products.datasource.util.Constants;
import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM "+ Constants.PRODUCT_TABLE_NAME)
    Flowable<List<Product>> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable addToFav(Product product);

    @Delete
    Completable deleteFromFav(Product product);
}