package com.example.he.fragmenttestapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TTEST";

    EventBus mainEventBus;
    Outer outer;
    FragmentReader fragmentReader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentReader = new FragmentReader();
        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction transaction = fManager.beginTransaction();
        transaction.replace(android.R.id.content, fragmentReader);
        transaction.commit();


        EventBus.getDefault().register(this);
        mainEventBus = new EventBus();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("harvic", "act clicked");
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        ArrayList news = DownloadJSON.getDatas(5);
//                        EventBus.getDefault().post(new MyEvent(news));
//                    }
//                }).start();
//            }
//        });
    }
//    @Subscribe
//    public void onEvent(MyEvent event){
//        Button buttonOfView2 = (Button)outer.view2.findViewById(R.id.fragment_button);
//        buttonOfView2.setText(event.getDats());
//    }

    @Subscribe
    public void onEvent(MyEvent event) {

        for (int i = 0; i < 5; i++) {
            TextView tv = (TextView) outer.viewList.get(i).findViewById(R.id.text1);
            tv.setMovementMethod(ScrollingMovementMethod.getInstance());
            tv.setText(event.getDats().get(i));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
