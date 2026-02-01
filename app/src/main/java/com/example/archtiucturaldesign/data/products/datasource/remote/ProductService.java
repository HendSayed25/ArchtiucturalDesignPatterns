package com.example.archtiucturaldesign.data.products.datasource.remote;

import com.example.archtiucturaldesign.data.products.datasource.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET(Constants.PRODUCTS)
    Call<ProductResponse> getProducts();
}
