package com.example.archtiucturaldesign.datasource.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.archtiucturaldesign.datasource.util.Constants;
import com.example.archtiucturaldesign.model.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM "+ Constants.PRODUCT_TABLE_NAME)
   LiveData<List<Product>>getAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addToFav(Product product);

    @Delete
    void deleteFromFav(Product product);
}