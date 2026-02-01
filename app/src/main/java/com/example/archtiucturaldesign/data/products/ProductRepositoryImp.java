package com.example.archtiucturaldesign.data.products;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.archtiucturaldesign.data.products.datasource.local.ProductLocalDataSource;
import com.example.archtiucturaldesign.data.products.datasource.remote.ProductNetworkResponse;
import com.example.archtiucturaldesign.data.products.datasource.remote.ProductRemoteDatasource;
import com.example.archtiucturaldesign.data.products.model.Product;
import com.example.archtiucturaldesign.presentation.allproducts.view.AllProductView;

import java.util.List;

public class ProductRepositoryImp implements ProductRepository {

    private ProductRemoteDatasource productRemoteDatasource;
    private ProductLocalDataSource productLocalDataSource;

    public ProductRepositoryImp(Context context) {
        productRemoteDatasource = new ProductRemoteDatasource();
        productLocalDataSource = new ProductLocalDataSource(context);
    }

    @Override
    public void getAllProducts(ProductNetworkResponse response) {
        productRemoteDatasource.getProducts(response);
    }

    @Override
    public void addFav(Product product) {
        productLocalDataSource.addToFav(product);
    }

    @Override
    public void deleteFromFav(Product product) {
        productLocalDataSource.deleteFromFav(product);
    }

    @Override
    public LiveData<List<Product>> getFavMovies() {
        return productLocalDataSource.getAllFavProducts();
    }
}
