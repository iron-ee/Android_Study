package com.cos.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

// 1. 컬렉션 정보
class ItemAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    public ItemAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    // 전체크기를 확인하기 위해서 필요 (나도, 어댑터도)
    @Override
    public int getCount() {
        return movies.size();
    }

    // 클릭하거나 어떤 이벤트 발생시에 컬렉션 정보를 확인하기 위해 필요
    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 객체를 생성해서 그림을 그리는 함수
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: "+position);
        if (convertView == null) {
            Log.d(TAG, "convertView가 null입니다.");
        }else {
            Log.d(TAG, "convertView가 null이 아닙니다.");
        }


        // 1. 부모 컨텍스트 가져오기 (Context <- MainActivity)
        Context context = parent.getContext();
        // MainActivity MainActivityContext = (MainActivity) parent.getContext(); // => 메인 액티비티는 다운캐스팅을 해줘야 context가 되는게 많으니깐 참고 !!
        // 2. 인플레이터 객체 생성 완료
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater inflater2 = LayoutInflater.from(context);    // 요새 새로 나온 문법

        // 강제성이 없어서 !
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubTitle = view.findViewById(R.id.tv_subtitle);
        tvTitle.setText(movies.get(position).getTitle());
        tvSubTitle.setText(movies.get(position).getSubTitle());

        view.setOnClickListener(v -> {
            //Toast.makeText(context, "클릭 됨"+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", movies.get(position).getTitle());
            context.startActivity(intent);
        });

        view.setOnLongClickListener(v -> {
            Toast.makeText(context, "롱 클릭"+position, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "movies 사이즈 :"+movies.size());
            movies.remove(position);
            Log.d(TAG, "movies 변경 사이즈 : "+movies.size());
            this.notifyDataSetChanged();    // 데이터변경 후 UI동기화시 호출해야 함.
            return true;
        });

        return view;
    }
}
