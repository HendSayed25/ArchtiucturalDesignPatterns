package com.example.archtiucturaldesign.datasource.remote;

import com.example.archtiucturaldesign.network.NetworkClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRemoteDatasource {
    private ProductService productService;

    public ProductRemoteDatasource() {
        productService = NetworkClient.getProductService();
    }

    public void getProducts(ProductNetworkResponse productNetworkResponse) {
        productService.getProducts().enqueue(new Callback<ProductResponse>() {

            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.code() == 200) {
                    productNetworkResponse.onSuccess(response.body().getProducts());
                } else {
                    productNetworkResponse.onError("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                if (t instanceof IOException) {
                    productNetworkResponse.noInternet();
                } else {
                    productNetworkResponse.onError("Something went wrong");
                }
            }
        });
    }
}