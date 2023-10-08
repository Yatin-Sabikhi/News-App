package com.project.newsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {
    private ArrayList<CategoryRVModal> categoryRVModals;
    private CategoryClickInterface categoryClickInterface;
    private Context context;

    public CategoryRVAdapter(ArrayList<CategoryRVModal> categoryRVModals, CategoryClickInterface categoryClickInterface, Context context) {
        this.categoryRVModals = categoryRVModals;
        this.categoryClickInterface = categoryClickInterface;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item, parent, false);
        return new CategoryRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRVAdapter.ViewHolder holder, int position) {
        CategoryRVModal categoryRVModal=categoryRVModals.get(position);
        holder.categoryTV.setText(categoryRVModal.getCategory());
        Picasso.get().load(categoryRVModal.getCategoryImageUrl()).into(holder.categoryIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickInterface.onCategoryClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryRVModals.size();
    }
    public interface CategoryClickInterface{
        void onCategoryClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryTV;
        private ImageView categoryIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTV=itemView.findViewById(R.id.TVCategory);
            categoryIV=itemView.findViewById(R.id.IVCategory);
        }
    }
}
