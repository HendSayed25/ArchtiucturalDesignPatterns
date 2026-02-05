package com.example.archtiucturaldesign.data.products.datasource.remote;

import android.annotation.SuppressLint;

import com.example.archtiucturaldesign.data.network.NetworkClient;

import java.io.IOException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRemoteDatasource {
    private ProductService productService;

    public ProductRemoteDatasource() {
        productService = NetworkClient.getProductService();
    }

    public Single<ProductResponse> getProducts() {
       return productService.getProducts();
    }
}