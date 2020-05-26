package com.example.myapplication7;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//어뎁터의 역활은 원하는 date를 리사이클러뷰에 실제로 그려주는 것
public class ACTAdapter extends RecyclerView.Adapter<ACTAdapter.ViewHolder> implements OnFoodItemClickListener {
    ArrayList<ACT> items = new ArrayList<ACT>();
    private ArrayList<ACT> select_list;
    OnFoodItemClickListener listener;


    @NonNull
    @Override
    //뷰홀더 초기화될때 실행하는 메소드
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //콘텍스트를 뷰그룹에서 가져와서 그걸 기반으로 레이아웃플레터 생성
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //생성된 레이아웃 플레터로 item_ex레이아웃을 가져와서 어떻게 뷰를 그릴지 결정
        View itemView = inflater.inflate(R.layout.recyclerview_item_ex, viewGroup, false);
        //뷰홀더를 생성하고 생성된 뷰 홀더를 바인드뷰홀더에 넘겨줌
        return new ViewHolder(itemView, this);
    }

    @Override
    //리사이클러뷰의 ROW 하나하나를 구현하기 위해 Bind(묶어)주는 메소드
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //리사이클러뷰에 들어갈 date(food로 이루어진 Arraylist배열)
        //해당 row위치에 해당하는 FOOd를 가져와서
        ACT item = items.get(position);
        //넘겨받은 뷰홀더의 레이아웃에 있는 뷰들을 어떻게 설정할지..
        holder.setItem(item);
    }

    @Override
    //어레이리스트의 food개수만큼 카운트 해주는 역활
    //이게 있어야 어레이리스트의 모든 음식 데이터를 그릴수 있음
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
    public void onItemClick(FoodAdapter.ViewHolder holder, View view, int position) {

    }

    //콘텍스트 메뉴를 사용하기 위하여 온크리에잇콘텍스트메뉴 리스트너를 임플리먼트 해주었음
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        TextView textView,textView2,textView3,textView4,textView5;
        //뷰홀더 생성
        public ViewHolder(@NonNull View itemView, final OnFoodItemClickListener listener) {
            super(itemView);
            //뷰들을 넘겨받아 뷰홀더를 완성시켜줌
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);
            itemView.setOnCreateContextMenuListener(this); // 온크리에잇 리스터 현재 클레스에 구현
            //온클릭부분
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

//    public void filter(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        items.clear();
//        if (charText.length() == 0) {
//            items.addAll(select_list);
//        } else {
//            for (Recent recent : select_list) {
//                String name = recent.getAddress();
//                if (name.toLowerCase().contains(charText)) {
//                    items.add(recent);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Delete = menu.add(Menu.NONE, 1002, 2, "삭제");
            Delete.setOnMenuItemClickListener(onMenuItemClickListener);

        }
        private final MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case 1001: //편집 클릭시
                        return true;

                    case 1002:
                        items.remove(getAdapterPosition());
                        // 7. 어댑터에서 RecyclerView에 반영하도록 합니다.
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), items.size());
                }
                return false;
            }
        };


    }
}
