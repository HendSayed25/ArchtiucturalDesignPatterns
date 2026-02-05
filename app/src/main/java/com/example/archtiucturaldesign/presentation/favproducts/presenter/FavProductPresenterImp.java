package com.example.archtiucturaldesign.presentation.favproducts.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.example.archtiucturaldesign.data.products.ProductRepository;
import com.example.archtiucturaldesign.data.products.ProductRepositoryImp;
import com.example.archtiucturaldesign.data.products.model.Product;
import com.example.archtiucturaldesign.presentation.favproducts.view.FavViews;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavProductPresenterImp implements FavProductsPresenter {

    private ProductRepository productsRepository;
    private FavViews view;

    public FavProductPresenterImp(Context context, FavViews view) {
        productsRepository = new ProductRepositoryImp(context);
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getFavProducts() {
        productsRepository.getFavProducts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                products -> {
                    view.showFavProducts(products);
                },
                throwable -> {
                }
        );
    }

    @Override
    public void deleteFromFav(Product product) {
        productsRepository.deleteFromFav(product)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}