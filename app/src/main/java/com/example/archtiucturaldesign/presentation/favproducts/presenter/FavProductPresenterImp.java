package com.example.archtiucturaldesign.presentation.favproducts.presenter;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.archtiucturaldesign.data.products.ProductRepository;
import com.example.archtiucturaldesign.data.products.ProductRepositoryImp;
import com.example.archtiucturaldesign.data.products.model.Product;
import com.example.archtiucturaldesign.presentation.allproducts.view.AllProductView;

import java.util.List;

public class FavProductPresenterImp implements FavProductsPresenter{

    private ProductRepository productsRepository;

    public FavProductPresenterImp(Context context){
        productsRepository = new ProductRepositoryImp(context);
    }
    @Override
    public LiveData<List<Product>> getFavProducts() {
        return productsRepository.getFavMovies();
    }

    @Override
    public void deleteFromFav(Product product) {
    productsRepository.deleteFromFav(product);
    }
}
