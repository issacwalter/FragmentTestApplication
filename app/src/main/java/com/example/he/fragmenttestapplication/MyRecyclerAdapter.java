package com.example.he.fragmenttestapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by He on 2016/5/16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.RecycViewHolder> {
    public static final String TAG = "TTEST";
    private boolean firstInit = false;
    public ArrayList<String> datas = new ArrayList<>();
    private String[] data2 = new String[DownloadJSON.getROWS()];
    private Context context;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
        if (!firstInit) {
            addItems(DownloadJSON.getROWS());
            datas.add(DownloadJSON.getJSON());


            firstInit = true;
        }
    }

    public void addItems(int howManyToAdd) {
        Log.d(TAG, "firstInit=" + firstInit + ";     input number" + howManyToAdd);
        for (int i = 0; i < howManyToAdd; i++) {
            //data2[i] = DownloadJSON.getDataFromNet();
            datas.add(i, "a" + i);
        }

    }


    @Override
    public RecycViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecycViewHolder holder = new RecycViewHolder(LayoutInflater.from(context).inflate(R.layout.item_of_recyclerview, parent, false));


        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.RecycViewHolder holder, int position) {
        holder.tv.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public static class RecycViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public RecycViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.textview_of_recycler_item);
        }
    }


}
