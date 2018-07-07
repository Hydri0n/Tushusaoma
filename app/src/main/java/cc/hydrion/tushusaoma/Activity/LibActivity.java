package cc.hydrion.tushusaoma.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cc.hydrion.tushusaoma.Adapter.LibListAdapter;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.MyHttpTask;
import cc.hydrion.tushusaoma.Utils.StyleUtil;

public class LibActivity extends Activity {

    private static int MAXNUM = 70;  //设置遍历的条目上限，避免查询过久

    private ListView listView;
    //private TextView textView;
    private String isbn;
    private String isbn10;
    private String title;
    private ProgressDialog dialog;
    private ImageButton backButton;
    SharedPreferences mPreferences;
    String school;

    private String result = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);

        StyleUtil.setStatusBar(this);

        mPreferences = getSharedPreferences("user",MODE_PRIVATE);
        school = mPreferences.getString("school","江西理工大学");

        //获取前一个activity发送的isbn号与书名
        isbn = getIntent().getStringExtra("isbn");
        isbn10 = getIntent().getStringExtra("isbn10");
        title = getIntent().getStringExtra("title");

        backButton = findViewById(R.id.lib_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listView = findViewById(R.id.listView);
        listView.setEmptyView(findViewById(R.id.empty_list2)); //设置记录为空时的内容
        //textView = (TextView) findViewById(R.id.textView);

        dialog = ProgressDialog.show(LibActivity.this,
                "提示","正在图书馆内搜索...",true);
        //dialog.show();
        try {
            ProgressAsyncTask asyncTask = new ProgressAsyncTask();
            asyncTask.execute(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ProgressAsyncTask
            extends MyHttpTask {


        @Override
        protected String getUrl() {
            String url = getResources().getString(R.string.libUrl);
            return url;
        }

        @Override
        protected String getCookie() {
            return "";
        }

        @Override
        protected Map<String, String> getParam() {
            Map<String,String> param = new HashMap<>();
            param.put("isbn",isbn);
            param.put("bookName",title);
            param.put("isbn10",isbn10);
            param.put("schoolId",school);
            return param;
        }


        @Override
        protected void onPostExecute(String result) {
            System.out.println(result);
            List<Map<String,String>> libInfos = new ArrayList<>();
            try{
                JSONObject jsonObject = new JSONObject(result);
                if (jsonObject.getString("code").equals("200")){
                    JSONArray details = jsonObject.getJSONArray("book");
                    for (int i = 0;i < details.length();i++){
                        Map<String,String> libInfo = new HashMap<>();
                        JSONObject detail = details.getJSONObject(i);
                        libInfo.put("status",detail.getString("state"));
                        libInfo.put("address",detail.getString("location"));
                        libInfos.add(libInfo);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            dialog.dismiss();
            listView.setAdapter(new LibListAdapter(LibActivity.this,libInfos,title));
        }

    }
}