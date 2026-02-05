package com.example.archtiucturaldesign.data.products.datasource.remote;

import com.example.archtiucturaldesign.data.products.datasource.util.Constants;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET(Constants.PRODUCTS)
    Single<ProductResponse> getProducts();
}