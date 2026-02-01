package com.example.archtiucturaldesign.data.products;


import androidx.lifecycle.LiveData;

import com.example.archtiucturaldesign.data.products.datasource.remote.ProductNetworkResponse;
import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

public interface ProductRepository {
     void getAllProducts(ProductNetworkResponse response);
     void addFav(Product product);
     void deleteFromFav(Product product);
     LiveData<List<Product>> getFavMovies();
}