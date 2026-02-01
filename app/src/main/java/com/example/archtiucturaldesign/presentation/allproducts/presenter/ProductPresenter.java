package com.example.archtiucturaldesign.presentation.allproducts.presenter;

import com.example.archtiucturaldesign.data.products.model.Product;

public interface ProductPresenter {
    void getAllProducts();
    void addToFav(Product product);
}