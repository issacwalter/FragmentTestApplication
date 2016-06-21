package com.example.he.fragmenttestapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by He on 2016/3/1.
 */
public class Inner2 extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TTEST", "inner2 onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TTEST", "inner2 onCreate");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TTEST", "inner2 onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TTEST", "inner2 onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TTEST", "inner2 onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TTEST", "inner2 onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TTEST", "inner2 onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TTEST", "inner2 onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TTEST", "inner2 onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TTEST", "inner2 onDetach");

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("TTEST","inner2 onCreateView");

        return inflater.inflate(R.layout.innerlayout2,container,false);
    }
}
