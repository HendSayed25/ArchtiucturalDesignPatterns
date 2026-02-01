package com.example.archtiucturaldesign.presentation.favproducts.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archtiucturaldesign.R;
import com.example.archtiucturaldesign.data.products.model.Product;
import com.example.archtiucturaldesign.presentation.favproducts.presenter.FavProductPresenterImp;
import com.example.archtiucturaldesign.presentation.favproducts.presenter.FavProductsPresenter;


public class FavActivity extends AppCompatActivity {

    private RecyclerView rvFavMovies;
    private FavoriteAdapter favoriteAdapter;

    private FavProductsPresenter favProductsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fav);

        init();

        favProductsPresenter.getFavProducts().observe(this,products->{
            favoriteAdapter.setList(products);
        });


        favoriteAdapter.onDeleteProductClick = new FavoriteAdapter.OnClickListener() {
            @Override
            public void onDeleteProductClick(Product product) {
                favProductsPresenter.deleteFromFav(product);
            }
        };
    }

    private void init() {
        rvFavMovies = findViewById(R.id.rvFavProducts);
        favoriteAdapter = new FavoriteAdapter();
        rvFavMovies.setAdapter(favoriteAdapter);
        favProductsPresenter = new FavProductPresenterImp(getApplicationContext());
    }
}