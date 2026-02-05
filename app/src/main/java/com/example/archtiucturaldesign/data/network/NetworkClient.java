package com.example.archtiucturaldesign.data.network;

import static com.example.archtiucturaldesign.data.products.datasource.util.Constants.BASE_URL;

import com.example.archtiucturaldesign.data.products.datasource.remote.ProductService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    private static Retrofit retrofit;
    private static ProductService productService;

    private NetworkClient() {}


    public static ProductService getProductService() {
        if (productService == null) {
            synchronized (NetworkClient.class) {
                productService = getInstance().create(ProductService.class);
            }
        }
        return productService;
    }

    private static Retrofit getInstance() {
        if (retrofit == null) {
            synchronized (NetworkClient.class) {
                retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .build();
            }
        }
        return retrofit;
    }
}