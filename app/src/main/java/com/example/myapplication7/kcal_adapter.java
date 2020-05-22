package com.example.myapplication7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

abstract class kcal_adapter extends RecyclerView.Adapter<kcal_adapter.ViewHolder> {
    private ArrayList<String> mData = null ;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView recyle_act, recyle_pal,recyle_text ;
        EditText recyle_hour;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            recyle_act = itemView.findViewById(R.id.recyle_act) ;
            recyle_pal = itemView.findViewById(R.id.recyle_pal) ;
            recyle_hour = itemView.findViewById(R.id.recyle_hour) ;
            recyle_text = itemView.findViewById(R.id.recyle_text) ;
            imageView = itemView.findViewById(R.id.imageView) ;

        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    kcal_adapter(ArrayList<String> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public kcal_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recyclerview_item_kcal, parent, false) ;
        kcal_adapter.ViewHolder vh = new kcal_adapter.ViewHolder(view) ;

        return vh ;
    }
    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String text = mData.get(position) ;
            holder.recyle_act.setText(text) ;
    }



    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}