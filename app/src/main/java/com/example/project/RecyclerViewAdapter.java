package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Recipe> recipes;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;


    RecyclerViewAdapter(Context context, ArrayList<Recipe> recipes, OnItemClickListener onItemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.recipes = recipes;
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Recipe recipe = recipes.get(position);
        //holder.title.setText(recipes.toString());
        holder.bind(recipes.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            //itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
        }

       /* @Override
        public void onClick(View view) {
            onItemClickListener.onClick(recipes.get(getAdapterPosition()));
        }

        */
        public void bind(final Recipe recipe, final OnItemClickListener listener) {
            title.setText(recipe.toString());
            //recipe.with(itemView.getContext()).load(recipe.imageUrl).into(image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(recipe);
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onItemClick(Recipe items);
    }
}
