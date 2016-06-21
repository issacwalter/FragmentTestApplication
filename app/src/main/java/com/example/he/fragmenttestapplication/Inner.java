package com.example.he.fragmenttestapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by He on 2016/3/1.
 */
public class Inner extends Fragment {
    private Button button;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TTEST", "inner onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TTEST", "inner onCreate");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TTEST", "inner onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TTEST", "inner onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TTEST", "inner onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TTEST", "inner onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TTEST", "inner onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TTEST", "inner onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TTEST", "inner onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TTEST", "inner onDetach");

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("TTEST","inner onCreateView");

        View view = inflater.inflate(R.layout.innerlayout,container,false);
        button = (Button)view.findViewById(R.id.innerbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                Inner2 inner2 = new Inner2() ;
                FragmentManager cManager = getChildFragmentManager();
                FragmentTransaction transaction = cManager.beginTransaction();
                transaction.replace(R.id.innerfram,inner2);
                transaction.commit();

            }
        });
        view.getBackground().setAlpha(100);
        return view;
    }
}
