package com.example.archtiucturaldesign.presentation.favproducts.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archtiucturaldesign.R;
import com.example.archtiucturaldesign.data.products.model.Product;
import com.example.archtiucturaldesign.presentation.favproducts.presenter.FavProductPresenterImp;
import com.example.archtiucturaldesign.presentation.favproducts.presenter.FavProductsPresenter;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class FavActivity extends AppCompatActivity implements FavViews {

    private RecyclerView rvFavMovies;
    private FavoriteAdapter favoriteAdapter;

    private FavProductsPresenter favProductsPresenter;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fav);

        init();

        favProductsPresenter.getFavProducts();

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
        favProductsPresenter = new FavProductPresenterImp(getApplicationContext(),this);
    }

    @Override
    public void showFavProducts(List<Product> products) {
        favoriteAdapter.setList(products);
    }
}