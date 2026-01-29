package com.example.archtiucturaldesign.allproducts.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archtiucturaldesign.R;
import com.example.archtiucturaldesign.allproducts.view.ProductAdapter;
import com.example.archtiucturaldesign.datasource.local.ProductLocalDataSource;
import com.example.archtiucturaldesign.datasource.remote.ProductNetworkResponse;
import com.example.archtiucturaldesign.datasource.remote.ProductRemoteDatasource;
import com.example.archtiucturaldesign.model.Product;

import java.util.List;

public class AllProductsActivity extends AppCompatActivity {

    private RecyclerView rvMovies;
    private ProductAdapter productAdapter;
    private ProgressBar progressCircular;
    private TextView tvError;

    public ProductRemoteDatasource productRemoteDatasource;
    public ProductLocalDataSource productLocalDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_products);

        init();

        productRemoteDatasource.getProducts(new ProductNetworkResponse() {

            @Override
            public void onSuccess(List<Product> products) {
                progressCircular.setVisibility(View.GONE);
                tvError.setVisibility(View.GONE);
                rvMovies.setVisibility(View.VISIBLE);
                productAdapter.setProductList(products);
            }

            @Override
            public void onError(String message) {
                progressCircular.setVisibility(View.GONE);
                tvError.setVisibility(View.VISIBLE);
                tvError.setText("Something went wrong" + message);
            }

            @Override
            public void noInternet() {
                progressCircular.setVisibility(View.GONE);
                tvError.setVisibility(View.VISIBLE);
                tvError.setText("No Internet Connection");
            }
        });

        productAdapter.onAddToFavClick = new ProductAdapter.onProductClickListener() {
            @Override
            public void onAddToFavClick(Product product) {
                productLocalDataSource.addToFav(product);
            }
        };
    }

    private void init() {
        rvMovies = findViewById(R.id.rv_products);
        progressCircular = findViewById(R.id.progress_circular);
        tvError = findViewById(R.id.tv_error);
        productRemoteDatasource = new ProductRemoteDatasource();
        productLocalDataSource = new ProductLocalDataSource(getApplicationContext());

        productAdapter = new ProductAdapter();
        rvMovies.setAdapter(productAdapter);
    }
}