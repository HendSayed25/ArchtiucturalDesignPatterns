package com.example.archtiucturaldesign.data.products.datasource.remote;

import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

public interface ProductNetworkResponse {
    void onSuccess(List<Product> products);
    void onError(String message);
    void noInternet();
}