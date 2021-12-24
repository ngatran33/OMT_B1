package com.example.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoffeeAdapter extends  RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>{
    List<Coffee> coffees;

    public CoffeeAdapter(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coffee,parent,false);
        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeAdapter.CoffeeViewHolder holder, int position) {
        Coffee coffee=coffees.get(position);
        holder.tv_title.setText(coffee.getTitle());
        holder.tv_description.setText(coffee.getDescription());
        holder.tv_id.setText(coffee.getId()+"");
    }

    @Override
    public int getItemCount() {
        return coffees.size();
    }
    public class CoffeeViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_description,tv_id;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id=itemView.findViewById(R.id.tv_id);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_description=itemView.findViewById(R.id.tv_description);
        }
    }
}
