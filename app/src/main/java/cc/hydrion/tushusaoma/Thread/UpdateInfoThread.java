package cc.hydrion.tushusaoma.Thread;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.application.MyApplication;


public class UpdateInfoThread extends Thread{

    private MyApplication mApplication;
    private URL url;
    private String cookie;
    private Handler mHandler;

    public static final int UPDATE_SUCCESS = 1;
    public static final int UPDATE_FAILED = 0;


    UpdateInfoThread(Context context, MyApplication application, String cookie, Handler handler) {
        mApplication = application;
        mHandler = handler;
        try {
            url = new URL(context.getResources().getString(R.string.url_information));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.cookie = cookie;
    }

    @Override
    public void run(){
        Message msg = new Message();
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.addRequestProperty("Cookie",cookie);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String str;
            StringBuffer sb = new StringBuffer();
            while((str = reader.readLine())!= null){
                sb.append(str);
            }

            JSONObject jsonObject = null;
            jsonObject = new JSONObject(sb.toString());
            if (jsonObject.getInt("code") == 200){
                mApplication.setUserId(jsonObject.getString("id"));
                mApplication.setUserName(jsonObject.getString("username"));
                mApplication.setSex(jsonObject.getString("sex"));
                mApplication.setSchool(jsonObject.getString("school"));
                mApplication.setCookie(cookie);
                msg.what = UPDATE_SUCCESS;
                Bundle bundle = new Bundle();

                msg.setData(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.what = UPDATE_FAILED;
        }
        finally {
            mHandler.sendMessage(msg);
        }
    }
}
