package com.example.archtiucturaldesign.presentation.favproducts.presenter;

import androidx.lifecycle.LiveData;

import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

public interface FavProductsPresenter {

    LiveData<List<Product>> getFavProducts();

    void deleteFromFav(Product product);
}
