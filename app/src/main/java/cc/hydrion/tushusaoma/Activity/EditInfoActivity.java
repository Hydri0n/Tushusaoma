package cc.hydrion.tushusaoma.Activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.StyleUtil;

public class EditInfoActivity extends AppCompatActivity {

    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;
    TextView tv_id;
    EditText et_name;
    TextView tv_sex;
    TextView tv_school;
    TextView commit;
    ImageButton backButton;
    String cookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        mPreferences = getSharedPreferences("user",MODE_PRIVATE);
        mEditor = mPreferences.edit();
        cookie = mPreferences.getString("cookie","");

        StyleUtil.setStatusBar(this);

        backButton = findViewById(R.id.edit_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });
        tv_id = findViewById(R.id.r_id);
        et_name = findViewById(R.id.r_name);
        tv_school = findViewById(R.id.r_school);
        tv_sex = findViewById(R.id.r_sex);
        commit = findViewById(R.id.commit);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_name.getText().toString().length() == 0)
                {
                    Toast.makeText(EditInfoActivity.this,
                            "用户名不能为空",Toast.LENGTH_SHORT).show();
                }
                else {
                    new CommitTask().execute(et_name.getText().toString(),
                            tv_sex.getText().toString(),
                            tv_school.getText().toString());
                }
            }
        });

//        tv_id.setText(getIntent().getStringExtra("userId"));
//        et_name.setText(getIntent().getStringExtra("userName"));
//        tv_school.setText(getIntent().getStringExtra("school"));
//        tv_sex.setText(getIntent().getStringExtra("sex"));

        tv_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] choice = new String[]{"保密","男","女"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EditInfoActivity.this);
                builder.setTitle("选择性别");
                builder.setSingleChoiceItems(choice, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (which == 0) tv_sex.setText("-");
                        else tv_sex.setText(choice[which]);
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
            }
        });
        tv_school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] choice = new String[]{"江西理工大学","赣南医学院"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EditInfoActivity.this);
                builder.setTitle("选择学校");
                builder.setSingleChoiceItems(choice, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        tv_school.setText(choice[which]);
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
            }
        });


        String sUrl = getResources().getString(R.string.url_information);
        try {
            URL url = new URL(sUrl);
            new HttpTask().execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onBackPressed(){
        quit();
    }

    private void finishActivity(){
        setResult(1);
        finish();
    }

    private void quit(){
        setResult(0);
        finish();
    }

    private class HttpTask extends AsyncTask<URL,Integer,String>{

        @Override
        protected String doInBackground(URL... urls) {
            try {
                HttpURLConnection conn = (HttpURLConnection) urls[0].openConnection();
                conn.setRequestMethod("GET");
                conn.setReadTimeout(5000);
                conn.addRequestProperty("Cookie",cookie);
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String str;
                StringBuffer sb = new StringBuffer();
                while((str = reader.readLine())!= null){
                    sb.append(str);
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result){
            //Log.i("RE",result);
            if (result != null){
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("code") == 200) {
                        tv_id.setText(jsonObject.getString("id"));
                        et_name.setText(jsonObject.getString("username"));
                        tv_sex.setText(jsonObject.getString("sex"));
                        tv_school.setText(jsonObject.getString("school"));
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Toast.makeText(EditInfoActivity.this,"获取信息失败！",Toast.LENGTH_SHORT).show();
            quit();


        }
    }

    class CommitTask extends AsyncTask<String,Integer,String>{

        private String userName;

        @Override
        protected String doInBackground(String... strings) {
            String result = null;
            userName = strings[0];
            try {
                String strUrl = getResources().getString(R.string.url_modify);
                strUrl =  strUrl + "?username=" + URLEncoder.encode(strings[0],"utf-8")
                        + "&sex=" + URLEncoder.encode(strings[1],"utf-8")
                        + "&school=" + URLEncoder.encode(strings[2],"utf-8");
                URL url = new URL(strUrl);
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
                result = sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result){
            if (result != null){
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("code") == 200){
                        mEditor.putString("userName",userName);
                        mEditor.putString("school",tv_school.getText().toString());
                        mEditor.apply();
                        Toast.makeText(EditInfoActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                        finishActivity();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
