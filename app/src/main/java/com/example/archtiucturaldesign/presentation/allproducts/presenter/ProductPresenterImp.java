package com.example.archtiucturaldesign.presentation.allproducts.presenter;

import android.app.Application;

import com.example.archtiucturaldesign.data.products.datasource.remote.ProductNetworkResponse;
import com.example.archtiucturaldesign.data.products.model.Product;
import com.example.archtiucturaldesign.data.products.ProductRepository;
import com.example.archtiucturaldesign.data.products.ProductRepositoryImp;
import com.example.archtiucturaldesign.presentation.allproducts.view.AllProductView;

import java.util.List;


public class ProductPresenterImp implements ProductPresenter {

    ProductRepository productRepository;
    AllProductView views;

    public ProductPresenterImp(Application application, AllProductView view) {
        productRepository = new ProductRepositoryImp(application.getApplicationContext());
        views = view;
    }

    @Override
    public void getAllProducts() {
        views.showLoading();
        productRepository.getAllProducts(new ProductNetworkResponse() {
            @Override
            public void onSuccess(List<Product> products) {
                views.hideLoading();
                views.showProducts(products);
            }

            @Override
            public void onError(String message) {
                views.showError(message);
            }

            @Override
            public void noInternet() {
                views.showError("No internet Connection");

            }
        });
    }

    @Override
    public void addToFav(Product product) {
        productRepository.addFav(product);
    }
}