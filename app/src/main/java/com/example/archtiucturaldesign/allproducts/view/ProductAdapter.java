package com.example.archtiucturaldesign.allproducts.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archtiucturaldesign.R;
import com.example.archtiucturaldesign.datasource.util.GlideImageLoader;
import com.example.archtiucturaldesign.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MovieViewHolder> {

    private List<Product> productList;
    public onProductClickListener onAddToFavClick;


    public ProductAdapter() {
        this.productList = new ArrayList<>();
        onAddToFavClick = null;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product);

        if(onAddToFavClick!=null){
            holder.addToFavoritesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onAddToFavClick.onAddToFavClick(product);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView movieImageView;
        private TextView movieTitleTextView;
        private TextView movieCategoryTextView;
        private Button addToFavoritesButton;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImageView = itemView.findViewById(R.id.iv_poster);
            movieTitleTextView = itemView.findViewById(R.id.tv_name);
            movieCategoryTextView = itemView.findViewById(R.id.tv_desc);
            addToFavoritesButton = itemView.findViewById(R.id.btn_addToFav);
        }

        public void bind(Product product) {
            movieTitleTextView.setText(product.getTitle());
            movieCategoryTextView.setText(product.getDescription());
            GlideImageLoader.load(itemView.getContext(),product.getThumbnail(),movieImageView);
        }
    }

    public interface onProductClickListener {
        void onAddToFavClick(Product product);
    }
}