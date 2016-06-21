package com.example.he.fragmenttestapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import okhttp3.OkHttpClient;

/**
 * Created by He on 2016/4/12.
 */
public class FragmentReader extends Fragment {
    public static final String TAG = "TTEST";
//    private String[] datas = new String[DownloadJSON.getROWS()];

    //JSON 获取字符串在这里还是adapter中初始化，即启动网络加载；用数组还是arraylist存放这些信息？使用何种本地存储方案？是否要用hashcode验证，避免重复加载？
    //JSON 请求为耗时操作 应启动多线程处理

    View view;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MyRecyclerAdapter myAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        for (int i = 0; i < datas.length; i++) {
//            datas[i] = DownloadJSON.getDataFromNet();
//        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentlayout_shit_reader, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.shit_reader);
        myAdapter = new MyRecyclerAdapter(getContext());

        linearLayoutManager = new LinearLayoutManager(getContext());
        //linearLayoutManager.setReverseLayout(true);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerOfRecycler(getContext(), DividerOfRecycler.VERTICAL_LIST));
        recyclerView.setAdapter(myAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int totalItems = myAdapter.datas.size() - 2;
                super.onScrollStateChanged(recyclerView, newState);
                Log.d(TAG, "visible: " + linearLayoutManager.findLastVisibleItemPosition() + "     total:" + totalItems);

                if (linearLayoutManager.findLastVisibleItemPosition() > totalItems) {
                    Log.d(TAG, "datas size: " + myAdapter.datas.size());
                    myAdapter.addItems(5);
                    myAdapter.notifyDataSetChanged();
                }
                ;
            }

        });
        return view;
    }
}
