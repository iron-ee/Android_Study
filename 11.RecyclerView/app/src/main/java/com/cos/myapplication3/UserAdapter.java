package com.cos.myapplication3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 3번 상속받기
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private static final String TAG = "UserAdapter";
    private final List<User> users;

    // 4번 컬렉션 생성
    public UserAdapter(List<User> users) {
        this.users = users;
    }

    // 5번 addItem, removeItem
    public void addItem(User user) {
        users.add(user);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        users.remove(position);
        notifyDataSetChanged();
    }




    // 1번 ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder 이다.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // 2번 user_item이 가지고 있는 위젯들을 선언
        private TextView tvId;
        private TextView tvUsername;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvUsername = itemView.findViewById(R.id.tv_username);
        }

        public void setItem(User user) {
            tvId.setText(user.getId().toString());
            tvUsername.setText(user.getUsername());
        }
    }

    // 7번 getView랑 똑같음.
    // 차이점이 있다면 listView는 화면에 3개가 필요하면 최초 로딩시에 3개를 그려야 하니깐 getView가 3번 호출됨.
    // 그 다음에 스크롤을 해서 2개가 추가되어야 될 때, 다시 getView를 호출함
    // 하지만 recyclerView는 스크롤을 해서 2개가 추가되야 될 때 onBindViewHolder를 호출함.
    // onCreateViewHolder는 해당 Activity 실행시에만 호출됨.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new MyViewHolder(view);  // view가 리스트뷰에 하나 그려짐.
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.setItem(users.get(position));
    }

    // 6번 컬렉션 크기 알려주기 (화면에 몇개 그려야 될지를 알아야 하기 때문)
    @Override
    public int getItemCount() {
        return users.size();
    }
}
