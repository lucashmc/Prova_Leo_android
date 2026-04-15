package com.example.prova_leo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> products = new ArrayList<>();

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct = products.get(position);
        holder.textViewName.setText(currentProduct.getName());
        holder.textViewCode.setText("Código: " + currentProduct.getCode());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "R$ %.2f", currentProduct.getPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewCode;
        private TextView textViewPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewProductName);
            textViewCode = itemView.findViewById(R.id.textViewProductCode);
            textViewPrice = itemView.findViewById(R.id.textViewProductPrice);
        }
    }
}