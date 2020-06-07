package com.example.myapplication7;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class repleadapter extends RecyclerView.Adapter<repleadapter.ViewHolder>  {
    private Context mContext;
    ArrayList<reple> items = new ArrayList<reple>();
    OnmemberItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //인플레이션을 통한 뷰 객체 생성
        View itemView = inflater.inflate(R.layout.forum_reple_item,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        reple item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(reple item){
        items.add(item);
    }
    public void setItems(ArrayList<reple> items){
        this.items = items;
    }
    public reple getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, reple item){
        items.set(position, item);
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView1,textView2,textView3,textView4;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            textView1 = itemView.findViewById(R.id.forum_reple_nickname);
            textView2 = itemView.findViewById(R.id.forum_reple_date);
            textView3 = itemView.findViewById(R.id.forum_reple_contents);
            textView4 = itemView.findViewById(R.id.forum_reple_amount);

        }
        public void setItem(reple item){
            textView1.setText(item.getNickname());
            textView2.setText(item.getDate());
            textView3.setText(item.getContents());

        }
    }
}
