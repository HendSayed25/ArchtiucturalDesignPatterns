package com.example.archtiucturaldesign.favproducts.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.archtiucturaldesign.R;
import com.example.archtiucturaldesign.datasource.util.GlideImageLoader;
import com.example.archtiucturaldesign.model.Product;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private List<Product> Products;
    public OnClickListener  onDeleteProductClick;

    public FavoriteAdapter() {
        this.Products = new java.util.ArrayList<>();
        onDeleteProductClick=null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_favorite, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product Product = Products.get(position);
        holder.bind(Product);
    }

    @Override
    public int getItemCount() {
        return Products.size();
    }

    public void setList(List<Product> updatedProducts) {
        this.Products = updatedProducts;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView favProductImg;
        TextView favProductName;
        TextView favProductCategory;
        Button removeFavBtn;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.constraint_fav_product);
            favProductName = itemView.findViewById(R.id.tv_fav_name);
            favProductCategory = itemView.findViewById(R.id.tv_fav_desc);
            removeFavBtn = itemView.findViewById(R.id.btn_fav_delete);
            favProductImg = itemView.findViewById(R.id.iv_fav_poster);
        }

        void bind(Product product) {
            favProductCategory.setText(product.getTitle());
            favProductName.setText(product.getDescription());
            GlideImageLoader.load(itemView.getContext(), product.getThumbnail(), favProductImg);

            removeFavBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   onDeleteProductClick.onDeleteProductClick(product);
                }
            });
        }
    }

    public interface OnClickListener {
        void onDeleteProductClick(Product product);
    }
}