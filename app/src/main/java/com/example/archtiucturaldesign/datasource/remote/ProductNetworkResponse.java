package com.example.archtiucturaldesign.datasource.remote;

import com.example.archtiucturaldesign.model.Product;

import java.util.List;

public interface ProductNetworkResponse {
    void onSuccess(List<Product> products);
    void onError(String message);
    void noInternet();
}