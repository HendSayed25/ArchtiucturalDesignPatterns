package com.example.archtiucturaldesign.data.products;

import android.content.Context;

import com.example.archtiucturaldesign.data.products.datasource.local.ProductLocalDataSource;
import com.example.archtiucturaldesign.data.products.datasource.remote.ProductRemoteDatasource;
import com.example.archtiucturaldesign.data.products.datasource.remote.ProductResponse;
import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public class ProductRepositoryImp implements ProductRepository {

    private ProductRemoteDatasource productRemoteDatasource;
    private ProductLocalDataSource productLocalDataSource;

    public ProductRepositoryImp(Context context) {
        productRemoteDatasource = new ProductRemoteDatasource();
        productLocalDataSource = new ProductLocalDataSource(context);
    }

    @Override
    public Single<ProductResponse> getAllProducts() {
        return productRemoteDatasource.getProducts();
    }

    @Override
    public Completable addFav(Product product) {
       return productLocalDataSource.addToFav(product);
    }

    @Override
    public Completable deleteFromFav(Product product) {
        return productLocalDataSource.deleteFromFav(product);
    }

    @Override
    public Flowable<List<Product>> getFavProducts() {
        return productLocalDataSource.getAllFavProducts();
    }
}