package com.example.he.fragmenttestapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.show.api.ShowApiRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by He on 2016/5/29.
 */
public class SecAct extends AppCompatActivity {
    Button button;
    TextView textView;
    protected Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec);

        button = (Button) findViewById(R.id.show_text);
        textView = (TextView) findViewById(R.id.json_text);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    //在新线程中发送网络请求
                    public void run() {
                        String appid = "19660";//要替换成自己的
                        String secret = "a1e3aad1be1840a28034a9495dca5f14";//要替换成自己的
                        final String res = new ShowApiRequest("http://route.showapi.com/341-1", appid, secret)
                                .addTextPara("time", "2015-07-10")
                                .addTextPara("page", "2")
                                .addTextPara("maxResult", "2")
                                .post();
                        // res is the original JSON String,which should be resolved with "JSON.parseObject(res, MyJSON.class)" to the outest class,
                        // which contains three system parameters:showapi_res_code,showapi_res_error,showapi_res_body,and the content we need is in the last one
                        MyJSON jsonobs = JSON.parseObject(res, MyJSON.class);
                        // get the data in the form of String,which contains contentlist, allpages,currentpage,ect.
                        String body = jsonobs.getShowapi_res_body();
                        // parse the data String to inner class,to get the member var which contains main text(jokes).
                        MyJSONofSubclass subclass = JSON.parseObject(body, MyJSONofSubclass.class);
                        // contentlist is an array,to be specific,a JSONArray.so we can get every class of the true content by using listOfGrandSubclass.get(i).getText()
                        final List<MyJSONofGrandSubclass> listOfGrandSubclass = JSON.parseArray(subclass.getContentlist(), MyJSONofGrandSubclass.class);


                        System.out.println(subclass);
                        //把返回内容通过handler对象更新到界面
                        mHandler.post(new Thread() {
                            public void run() {
                                StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < listOfGrandSubclass.size(); i++) {
                                    sb.append(listOfGrandSubclass.get(i).getText());
                                    sb.append("\n");
                                    sb.append("********");
                                    sb.append("\n");

                                }


                                textView.setText(sb.toString());
                            }
                        });
                    }
                }.start();
            }
        });
    }
}
