package com.example.archtiucturaldesign.presentation.allproducts.presenter;

import android.annotation.SuppressLint;
import android.app.Application;

import com.example.archtiucturaldesign.data.products.model.Product;
import com.example.archtiucturaldesign.data.products.ProductRepository;
import com.example.archtiucturaldesign.data.products.ProductRepositoryImp;
import com.example.archtiucturaldesign.presentation.allproducts.view.AllProductView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ProductPresenterImp implements ProductPresenter {

    ProductRepository productRepository;
    AllProductView views;

    public ProductPresenterImp(Application application, AllProductView view) {
        productRepository = new ProductRepositoryImp(application.getApplicationContext());
        views = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getAllProducts() {
        views.showLoading();
        productRepository.getAllProducts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        productResponse -> {
                            views.hideLoading();
                            views.showProducts(productResponse.getProducts());
                        },
                        throwable -> {
                            views.hideLoading();
                            views.showError(throwable.getMessage());
                        }
                );
    }

    @Override
    public void addToFav(Product product) {
        productRepository.addFav(product).subscribeOn(Schedulers.io()).subscribe();
    }
}