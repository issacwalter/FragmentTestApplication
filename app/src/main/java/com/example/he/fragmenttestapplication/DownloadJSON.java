package com.example.he.fragmenttestapplication;

import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by He on 2016/5/20.
 */
public class DownloadJSON {
    private static int ROWS = 8;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    public static ArrayList<String> news;
    public static final String httpUrl = "http://apis.baidu.com/tngou/info/news";
    public static final String httpArg = "id=0&classify=0&rows=" + ROWS;

    public static void setRows(int rows) {
        DownloadJSON.ROWS = rows;
    }

    public static int getROWS() {
        return ROWS;
    }

    public static ArrayList<String> getDatas(int rows) {
        setRows(rows);
        ArrayList<String> news = new ArrayList();
        String jsonResult = request(httpUrl, httpArg);
        MyJSON jsonobs = JSON.parseObject(jsonResult, MyJSON.class);
//        for (int i = 0; i < ROWS; i++) {
//            JSONObject objs = (JSONObject) jsonobs.getTngou().get(i);
//            String report = JSON.parseObject(objs.toJSONString(), Info.class).getMessage()
//                    .replaceAll("<[0-9A-Za-z|/]{0,}>", "").trim();
//            news.add(report);
//        }
        return news;
    }

    public static String getJSON() {
        final String https = httpUrl + "?" + httpArg;
        final RequestBody requestBody = new FormBody.Builder()
                .add("apikey", "e250f92fca9b6bdd00c937a0614a852f")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(https)
                        .post(requestBody)
                        .build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        System.out.println(response.code());
                        System.out.println(response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return "a";
    }


    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", "e250f92fca9b6bdd00c937a0614a852f");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
