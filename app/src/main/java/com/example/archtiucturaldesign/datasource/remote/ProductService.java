package com.example.archtiucturaldesign.datasource.remote;

import com.example.archtiucturaldesign.datasource.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET(Constants.PRODUCTS)
    Call<ProductResponse> getProducts();
}
