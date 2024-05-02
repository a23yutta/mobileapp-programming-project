package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder>{
    private ArrayList<Recipe> recipes;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, ArrayList<Recipe> recipes, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.recipes = recipes;
        this.onClickListener = onClickListener;
    }
    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.title.setText(recipe.toString());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(recipes.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(Recipe items);
    }
}
