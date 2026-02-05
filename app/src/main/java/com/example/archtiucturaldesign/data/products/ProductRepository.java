package com.example.archtiucturaldesign.data.products;


import com.example.archtiucturaldesign.data.products.datasource.remote.ProductResponse;
import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface ProductRepository {
     Single<ProductResponse> getAllProducts();
     Completable addFav(Product product);
     Completable deleteFromFav(Product product);
     Flowable<List<Product>> getFavProducts();
}