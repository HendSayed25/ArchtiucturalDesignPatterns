package com.example.archtiucturaldesign.presentation.allproducts.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archtiucturaldesign.R;
import com.example.archtiucturaldesign.presentation.allproducts.presenter.ProductPresenter;
import com.example.archtiucturaldesign.presentation.allproducts.presenter.ProductPresenterImp;

import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

public class AllProductsActivity extends AppCompatActivity implements AllProductView {

    private RecyclerView rvMovies;
    private ProductAdapter productAdapter;
    private ProgressBar progressCircular;
    private TextView tvError;

    private ProductPresenter productPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_products);

        init();

        productPresenter.getAllProducts();

        productAdapter.onAddToFavClick = new ProductAdapter.onProductClickListener() {
            @Override
            public void onAddToFavClick(Product product) {
               productPresenter.addToFav(product);
            }
        };
    }

    private void init() {
        rvMovies = findViewById(R.id.rv_products);
        progressCircular = findViewById(R.id.progress_circular);
        tvError = findViewById(R.id.tv_error);
        productPresenter = new ProductPresenterImp(getApplication(),this);

        productAdapter = new ProductAdapter();
        rvMovies.setAdapter(productAdapter);
    }

    @Override
    public void showLoading() {
        progressCircular.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressCircular.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        tvError.setVisibility(View.VISIBLE);
        tvError.setText(message);
    }

    @Override
    public void showProducts(List<Product> product) {
        rvMovies.setVisibility(View.VISIBLE);
        productAdapter.setProductList(product);
    }
}