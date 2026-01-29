package com.example.archtiucturaldesign.favproducts.controller;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archtiucturaldesign.R;
import com.example.archtiucturaldesign.datasource.local.ProductLocalDataSource;
import com.example.archtiucturaldesign.favproducts.view.FavoriteAdapter;
import com.example.archtiucturaldesign.model.Product;

public class FavActivity extends AppCompatActivity {

    private RecyclerView rvFavMovies;
    private FavoriteAdapter favoriteAdapter;
    private ProductLocalDataSource productLocalDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fav);

        init();

        productLocalDataSource.getAllFavProducts().observe(this, products -> {
            favoriteAdapter.setList(products);
        });

        favoriteAdapter.onDeleteProductClick = new FavoriteAdapter.OnClickListener() {
            @Override
            public void onDeleteProductClick(Product product) {
                productLocalDataSource.deleteFromFav(product);
            }
        };
    }

    private void init() {
        rvFavMovies = findViewById(R.id.rvFavProducts);
        favoriteAdapter = new FavoriteAdapter();
        rvFavMovies.setAdapter(favoriteAdapter);
        productLocalDataSource = new ProductLocalDataSource(this);
    }
}