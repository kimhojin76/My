package com.example.myapplication7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import java.util.Dictionary;

public class memberAdapter extends RecyclerView.Adapter<memberAdapter.ViewHolder> implements OnmemberItemClickListener {
    private Context mContext;
    public ArrayList<member> items = new ArrayList<member>();
    OnmemberItemClickListener listener;



    @NonNull
    @Override
    //뷰홀더 초기화될때 실행하는 메소드
    public memberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //콘텍스트를 뷰그룹에서 가져와서 그걸 기반으로 레이아웃 플레터 생성
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //생성된 레이아웃 플레터로 xml레이아웃을 가져와 뷰를 어떻게 그릴지 결정
        View itemView = inflater.inflate(R.layout.forum_item2,parent,false);
        //뷰홀더를 생성하고 생성된 뷰 홀더를 바인드 뷰 홀더로 넘겨줌
        return new ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull memberAdapter.ViewHolder holder, int position) {
        //리사이클러뷰에 들어갈 data(member로 이루어진 arraylist 배열)
        //해당 row 위치에 해당하는 member를 가져와서
        member item = items.get(position);
        //넘겨받은 뷰홀더의 레이아웃에 있는 뷰들을 어떻게 설정할지..
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {return items.size();}
    public void addItem(member item){items.add(item);}
    public member getitem(int position){return items.get(position);}
    public void setitem(int position,member item){items.set(position,item);}

    public void setOnItemClickListener(OnmemberItemClickListener listener){
        this.listener=listener;
    }


    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        TextView nickname, title, date,contents,amount;
        ImageView profile_image;

        //뷰홀더 생성
        public ViewHolder(@NonNull View itemView, final OnmemberItemClickListener listener) {
            super(itemView);
            //뷰들을 넘겨받아 뷰홀더를 완성시켜줌
            nickname = itemView.findViewById(R.id.forum_nickname);
            title = itemView.findViewById(R.id.forum_title);
            date = itemView.findViewById(R.id.forum_date);
            contents = itemView.findViewById(R.id.forum_contents);
            amount = itemView.findViewById(R.id.forum_reple_amount);

            itemView.setOnCreateContextMenuListener(this); // 온크리에잇 리스터 현재 클레스에 구현
            //온클릭부분
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(memberAdapter.ViewHolder.this,v,position);
                    }
                }
            });
//d
        }
        public void setItem(member item){
            nickname.setText(item.getNickname());
            title.setText(item.getTitle());
            date.setText(item.getDate());
            contents.setText(item.getContents());
            Log.v("맴버 아답터 엑티비티", "셋아이템 체크");
            if(item.getReple_amount()!=null){
                if(!item.getReple_amount().equals("0")) {
                    Log.v("맴버 아답터 엑티비티", "널값체크");
                    Log.v("맴버 아답터 엑티비티", "[" + item.getReple_amount() + "]");

                    amount.setText("[" + item.getReple_amount() + "]");
                }
            }
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
//            MenuItem Edit = menu.add(Menu.NONE,1001,1,"수정");
//            MenuItem Delete = menu.add(Menu.NONE, 1002, 2, "삭제");
//            Edit.setOnMenuItemClickListener(onMenuItemClickListener);
//            Delete.setOnMenuItemClickListener(onMenuItemClickListener);

        }
        private final MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case 1001: //편집 클릭시
//                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//
//                        // 다이얼로그를 보여주기 위해 edit_box.xml 파일을 사용합니다.
//
//                        View view = LayoutInflater.from(mContext)
//                                .inflate(R.layout.forum_edit, null, false);
//                        builder.setView(view);
//                        final Button ButtonSubmit = (Button) view.findViewById(R.id.forum_edit_register);
//                        final EditText editTexttitle = (EditText) view.findViewById(R.id.forum_edit_title);
//                        final EditText editTextcontents = (EditText) view.findViewById(R.id.forum_edit_contents);
//                        final TextView editTextdate = (TextView) view.findViewById(R.id.forum_edit_date);
//                        final TextView editTextnickname = (TextView) view.findViewById(R.id.forum_edit_nickname);
//                        editTextID.setText(mList.get(getAdapterPosition()).getId());
//                        editTextEnglish.setText(mList.get(getAdapterPosition()).getEnglish());
//                        editTextKorean.setText(mList.get(getAdapterPosition()).getKorean());
//                        final AlertDialog dialog = builder.create();
//                        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
//
//
//                            @Override
//                            public void onClick(View v) {
//                                String strID = editTextID.getText().toString();
//                                String strEnglish = editTextEnglish.getText().toString();
//                                String strKorean = editTextKorean.getText().toString();
//
//                                Dictionary dict = new Dictionary(strID, strEnglish, strKorean );
//
//
//                                // 8. ListArray에 있는 데이터를 변경하고
//                                mList.set(getAdapterPosition(), dict);
//
//
//                                // 9. 어댑터에서 RecyclerView에 반영하도록 합니다.
//
//                                notifyItemChanged(getAdapterPosition());
//
//                                dialog.dismiss();
//                            }
//                        });
//                        dialog.show();

                        break;
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
