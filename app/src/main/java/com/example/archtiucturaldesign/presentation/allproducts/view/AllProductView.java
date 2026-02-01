package com.example.archtiucturaldesign.presentation.allproducts.view;

import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

public interface AllProductView {
    void showLoading();
    void hideLoading();
    void showError(String message);
    void showProducts(List<Product> product);
}
