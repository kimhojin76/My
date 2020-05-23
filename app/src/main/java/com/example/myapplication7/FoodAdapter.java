package com.example.myapplication7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> implements OnFoodItemClickListener {
    ArrayList<Food> items = new ArrayList<Food>();
    OnFoodItemClickListener listener;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.recyclerview_item_ex, viewGroup, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Food item){
        items.add(item);
    }
    public void setItems(ArrayList<Food> items){
        this.items = items;
    }
    public Food getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, Food item){
        items.set(position, item);
    }

    public void setOnItemClickListener(OnFoodItemClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
            TextView textView,textView2,textView3,textView4,textView5;

            public ViewHolder(@NonNull View itemView, final OnFoodItemClickListener listener) {
                super(itemView);

                textView = itemView.findViewById(R.id.textView);
                textView2 = itemView.findViewById(R.id.textView2);
                textView3 = itemView.findViewById(R.id.textView3);
                textView4 = itemView.findViewById(R.id.textView4);
                textView5 = itemView.findViewById(R.id.textView5);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        if(listener != null){
                            listener.onItemClick(ViewHolder.this,v,position);
                        }
                    }
                });

            }
            public void setItem(Food item){
                textView.setText(item.getName());
                textView2.setText(item.getKcal());
                textView3.setText(item.getCar());
                textView4.setText(item.getPro());
                textView5.setText(item.getFat());

            }
        }
}
