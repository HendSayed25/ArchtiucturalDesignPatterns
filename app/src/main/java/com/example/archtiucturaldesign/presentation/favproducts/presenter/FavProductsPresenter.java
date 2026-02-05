package com.example.archtiucturaldesign.presentation.favproducts.presenter;

import androidx.lifecycle.LiveData;

import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface FavProductsPresenter {

    void getFavProducts();

    void deleteFromFav(Product product);
}