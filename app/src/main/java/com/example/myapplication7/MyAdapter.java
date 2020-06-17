package com.example.myapplication7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //데이터 배열 선언
    private ArrayList<Food> mList;

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_title,textView_kcal,textView_fat,textView_weight, textView_car, texView_pro;

        public ViewHolder(View itemView) {
            super(itemView);

            textView_title = (TextView) itemView.findViewById(R.id.textView);
            textView_kcal = (TextView) itemView.findViewById(R.id.textView2);
            textView_car = (TextView) itemView.findViewById(R.id.textView3);
            texView_pro = (TextView) itemView.findViewById(R.id.textView4);
            textView_fat = (TextView) itemView.findViewById(R.id.textView5);
            textView_weight = (TextView) itemView.findViewById(R.id.textView6);

        }
    }

    //생성자
    public MyAdapter(ArrayList<Food> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_fs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        holder.textView_title.setText(String.valueOf(mList.get(position).getName()));
        holder.textView_kcal.setText(String.valueOf(mList.get(position).getKcal()));
        holder.textView_car.setText(String.valueOf(mList.get(position).getCar()));
        holder.texView_pro.setText(String.valueOf(mList.get(position).getPro()));
        holder.textView_fat.setText(String.valueOf(mList.get(position).getFat()));
        holder.textView_weight.setText(String.valueOf(mList.get(position).getWeight()));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}