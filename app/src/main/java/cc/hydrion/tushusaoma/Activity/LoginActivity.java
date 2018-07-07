package cc.hydrion.tushusaoma.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import cc.hydrion.tushusaoma.Event.LoginEvent;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.StyleUtil;
import cc.hydrion.tushusaoma.application.MyApplication;

public class LoginActivity extends AppCompatActivity {

    public final static int REQUEST_CODE = 10000;
    public final static int RESULT_CODE_SUCCESS = 1;
    public final static int RESULT_CODE_FAILED = 0;

    private EditText et_userId;
    private EditText et_password;
    private ImageButton mImageButton;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    //private MyApplication userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StyleUtil.setStatusBar(this);

        //userInfo = (MyApplication)getApplication();

        mPreferences = getSharedPreferences("user",MODE_PRIVATE);
        mEditor = mPreferences.edit();

        et_userId = findViewById(R.id.login_edit_userId);
        et_password = findViewById(R.id.login_edit_password);
        mImageButton = findViewById(R.id.login_backButton);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        //Boolean resultStatus = data.getExtras().getBoolean("result");
//        setInfo(data.getStringExtra("userId"),
//                data.getStringExtra("userName"),
//                data.getStringExtra("cookie"));
        if (resultCode == RegisterActivity.RESULTCODE_REGISETER_SUCCESS){
            finishLogined();
        }
    }

    @Override
    public void onBackPressed(){
        finishActivity();
    }

    private void finishLogined(){
        setResult(RESULT_CODE_SUCCESS);
        EventBus.getDefault().post(new LoginEvent());
        finish();
    }

    private void finishActivity(){
        //intent.putExtra("result",false);
        setResult(RESULT_CODE_FAILED);

        finish();
    }

    private class HttpTask extends AsyncTask<URL,Integer,Integer> {

        @Override
        protected Integer doInBackground(URL... urls) {
            try {
                HttpURLConnection conn = (HttpURLConnection) urls[0].openConnection();
                conn.setRequestMethod("GET");
                conn.setReadTimeout(5000);
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final String cookieString = conn.getHeaderField("Set-Cookie");
                Log.i("SESSIONID",cookieString);
                mEditor.putString("cookie",cookieString);
                mEditor.apply();
                String str;
                StringBuffer sb = new StringBuffer();
                while((str = reader.readLine())!= null){
                    sb.append(str);
                }
                conn.disconnect();
                reader.close();
                JSONObject jsonObject = new JSONObject(sb.toString());
                int code = jsonObject.getInt("code");
                if (code == 200){
                    //获取详细信息
                    conn = (HttpURLConnection) urls[1].openConnection();
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(5000);
                    conn.addRequestProperty("Cookie",cookieString);
                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    sb = new StringBuffer();
                    while((str = reader.readLine())!= null){
                        sb.append(str);
                    }
                    jsonObject = new JSONObject(sb.toString());
                    if (jsonObject.getInt("code") == 200) {
                        mEditor.putString("userName",jsonObject.getString("username"));
                        mEditor.putString("school",jsonObject.getString("school"));
                        mEditor.apply();
                    }
                }
                return code;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }

        }

        protected  void onPostExecute(Integer result){
            switch (result){
                case 200 :
                    Toast.makeText(LoginActivity.this,
                            "登录成功",Toast.LENGTH_SHORT).show();
                    mEditor.putString("userId",et_userId.getText().toString());
                    mEditor.apply();
                    //Intent intent = new Intent();
                    finishLogined();
                    break;
                default:
                    Toast.makeText(LoginActivity.this,
                            "登录失败",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void register(View view){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
    }

    public void commit(View view){
        String id = et_userId.getText().toString();
        String pwd = et_password.getText().toString();

        String url = getResources().getString(R.string.url_login);
        try {
            url = url + "?id=" + URLEncoder.encode(id,"utf-8")
                    + "&pwd=" + URLEncoder.encode(pwd,"utf-8");
            System.out.println(url);
            URL httpUrl1 = new URL(url);
            URL httpUrl2 = new URL(getResources().getString(R.string.url_information));
            HttpTask httpTask = new HttpTask();
            httpTask.execute(httpUrl1,httpUrl2);

        } catch (UnsupportedEncodingException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
