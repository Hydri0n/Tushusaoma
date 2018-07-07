package cc.hydrion.tushusaoma.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.StyleUtil;
import cc.hydrion.tushusaoma.application.MyApplication;

public class RegisterActivity extends AppCompatActivity {

    public static final int RESULTCODE_REGISETER_SUCCESS = 1;
    public static final int RESULTCODE_REGISETER_FAILED = 0;

    private EditText et_userName;
    private EditText et_userId;
    private EditText et_password;
    private EditText et_repeatPassword;
    private Spinner spinner;
    private ImageButton mImageButton;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private String school = "江西理工大学";
    //private MyApplication userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        StyleUtil.setStatusBar(this);

        //userInfo = (MyApplication)getApplication();

        mPreferences = getSharedPreferences("user",MODE_PRIVATE);
        mEditor = mPreferences.edit();

        et_userId = findViewById(R.id.register_edit_userId);
        et_userName = findViewById(R.id.register_edit_userName);
        et_password = findViewById(R.id.register_edit_password);
        et_repeatPassword =findViewById(R.id.register_edit_rePassword);
        spinner = findViewById(R.id.spinner);
        mImageButton = findViewById(R.id.register_backButton);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });

        List<String> list = new ArrayList<>();
        list.add("江西理工大学");
        list.add("赣南医学院");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                school = (String) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                school = "江西理工大学";
            }
        });

    }

    @Override
    public void onBackPressed(){
        finishActivity();
    }

    private void finishActivity(){
        //intent.putExtra("result",false);
        setResult(RESULTCODE_REGISETER_FAILED);
        finish();
    }



    private class HttpTask extends AsyncTask<URL,Integer,String[]>{

        @Override
        protected String[] doInBackground(URL... urls) {
            try {
                HttpURLConnection conn = (HttpURLConnection) urls[0].openConnection();
                conn.setRequestMethod("GET");
                conn.setReadTimeout(5000);
                String cookieString = conn.getHeaderField("Set-Cookie");
                Log.i("cookie",cookieString);
                mEditor.putString("cookie",cookieString);
                mEditor.apply();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String str;
                StringBuffer sb = new StringBuffer();
                while((str = reader.readLine())!= null){
                    sb.append(str);
                }
                return new String[]{sb.toString(),cookieString};
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        protected  void onPostExecute(String result[]){
            if (result != null) {
                System.out.println("result:" + result[0]);
                JSONObject jsonObject = null;
                //报错，json格式有问题？
                try {
                    jsonObject = new JSONObject(result[0]);
                    String message = jsonObject.getString("message");
                    Toast.makeText(RegisterActivity.this,message,
                            Toast.LENGTH_SHORT).show();
                    switch (jsonObject.getInt("code")){
                        case 200:
                            Toast.makeText(RegisterActivity.this,"注册成功",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
//                            intent.putExtra("cookie",result[1]);
//                            intent.putExtra("userId",et_userId.getText().toString());
//                            intent.putExtra("userName",et_userName.getText().toString());
                            mEditor.putString("userId",et_userId.getText().toString());
                            mEditor.putString("userName",et_userName.getText().toString());
                            mEditor.putString("school",school);
                            mEditor.apply();
                            setResult(RESULTCODE_REGISETER_SUCCESS,intent);
                            finish();break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(RegisterActivity.this,"注册失败！",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void commit(View view){
        String id = et_userId.getText().toString();
        String pwd = et_password.getText().toString();
        String rpwd = et_repeatPassword.getText().toString();
        String username = et_userName.getText().toString();
        String school = this.school;
        String sex = "-";

        if (id.length() == 0 || pwd.length() == 0 || username.length() == 0
                || rpwd.length() == 0)
            Toast.makeText(RegisterActivity.this,
                    "填写信息不完全！",Toast.LENGTH_SHORT).show();
        else if (!pwd.equals(rpwd))
            Toast.makeText(RegisterActivity.this,
                    "两次输入密码不一致！",Toast.LENGTH_SHORT).show();
        else {
            String url = getResources().getString(R.string.url_register);
            try {
                url = url + "?id=" + URLEncoder.encode(id,"utf-8")
                        + "&username=" + URLEncoder.encode(username,"utf-8")
                        + "&pwd=" + URLEncoder.encode(pwd,"utf-8")
                        + "&sex=" + URLEncoder.encode(sex,"utf-8")
                        + "&school=" + URLEncoder.encode(school,"utf-8");
                System.out.println(url);
                URL httpUrl = new URL(url);
                HttpTask httpTask = new HttpTask();
                httpTask.execute(httpUrl);

            } catch (UnsupportedEncodingException | MalformedURLException e) {
                e.printStackTrace();
            }
        }

    }
}
