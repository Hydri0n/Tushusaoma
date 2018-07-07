package cc.hydrion.tushusaoma.Activity;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.apache.http.HttpException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cc.hydrion.tushusaoma.Adapter.FavorListAdapter;
import cc.hydrion.tushusaoma.Adapter.HistoryListAdapter;
import cc.hydrion.tushusaoma.Adapter.SearchBookAdapter;
import cc.hydrion.tushusaoma.Bean.BookLocation;
import cc.hydrion.tushusaoma.Bean.FavorBook;
import cc.hydrion.tushusaoma.Bean.HistoryBook;
import cc.hydrion.tushusaoma.Bean.UserInfo;
import cc.hydrion.tushusaoma.Event.LoginEvent;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.MyHttpTask;
import cc.hydrion.tushusaoma.Utils.SQLHelper;
import cc.hydrion.tushusaoma.Utils.StyleUtil;
import cc.hydrion.tushusaoma.application.MyApplication;
import cc.hydrion.tushusaoma.sql.BookLocationDB;
import cc.hydrion.tushusaoma.sql.HistoryDB;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_LOGIN = 10000;
    public static final int REQUEST_CODE_DETAIL = 10001;
    public static final int REQUEST_CODE_EDIT_HEADER = 10002;
    public static final int REQUEST_CODE_EDIT_INFO = 10003;

    private boolean isLoggin = false;

    //public MyApplication mUserInfo;
    EditText et_search;
    NavigationView leftNavigation;
    DrawerLayout drawerLayout;
    TextView tv_userName;
    TextView tv_userId;
    ListView lv_favorites;
    ListView lv_historyList;
    View header_favor;
    List<FavorBook> favorBooks = new ArrayList<FavorBook>();
    List<BookLocation> mBookLocations = new ArrayList<BookLocation>();
    RelativeLayout emptyListView1;
//    SwipeRefreshLayout mSwipeRefreshLayout;
//    SwipeRefreshLayout mSwipeRefreshLayout2;
    //FavoritesPageAdapter mFavoritesPageAdapter;

    HistoryListAdapter historyListAdapter = null;

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences("user",MODE_PRIVATE);
        mEditor = mPreferences.edit();

        EventBus.getDefault().register(this);

        et_search = findViewById(R.id.et_search);
        drawerLayout = findViewById(R.id.drawerLayout);
        leftNavigation = findViewById(R.id.leftNavigation);
        View header = leftNavigation.getHeaderView(0);
        tv_userName = header.findViewById(R.id.header_name);
        tv_userId = header.findViewById(R.id.header_id);
        lv_favorites = findViewById(R.id.list1);
        lv_historyList = findViewById(R.id.list2);
        emptyListView1 = findViewById(R.id.empty_list1);

        lv_historyList.setEmptyView(findViewById(R.id.empty_list2));

        header_favor = View.inflate(MainActivity.this,
                R.layout.header_favorites,null);
        new LoginTask().execute();
        //refreshInfo();

        //检查相机权限情况并申请权限
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED )
        {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    1);
        }

        //设置tabhost
        TabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1");//(通过帧布局实现)
        tabSpec.setIndicator(getResources().getString(R.string.main_tab1));//设置标签题
        tabSpec.setContent(R.id.tab1);//设置内容
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("tab2");
        tabSpec.setIndicator(getResources().getString(R.string.main_tab2));
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);
        //tabHost.setCurrentTab(0);
        upDateTab(tabHost);


        //添加列表头布局
        //new FavorListTask().execute();



        //设置适配器
        lv_historyList.setAdapter(historyListAdapter);

        //设置按键监听
        tv_userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isLoggin)
                {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivityForResult(intent,REQUEST_CODE_LOGIN);
                }
            }
        });
        leftNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_edit_info:
                        if (isLoggin){
                            Intent intent = new Intent(MainActivity.this, EditInfoActivity.class);
                            startActivityForResult(intent,REQUEST_CODE_EDIT_INFO);
                        }
                        else Toast.makeText(MainActivity.this,
                                "未登录帐号",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.menu_comments:
                        if (isLoggin){
                            Intent intent = new Intent(MainActivity.this,MyCommentsActivity.class);
                            startActivity(intent);
                        } else Toast.makeText(MainActivity.this,
                                "未登录帐号",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_help:
                        Intent intent = new Intent(MainActivity.this,WelcomeGuideActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.menu_feedback :
                        Intent intent2 = new Intent(MainActivity.this,FeedBackActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.menu_quit:
                        //TODO 退出
                        //mUserInfo.clear();
                        if (isLoggin) new LogoutTask().execute();
                        else Toast.makeText(MainActivity.this,
                                "未登录帐号",Toast.LENGTH_SHORT).show();
                        break;
                }
                item.setChecked(false);
                drawerLayout.closeDrawers();
                return true;
            }
        });


        //设置状态栏的颜色
        //6.0以前的版本不支持切换状态栏的深浅色
        StyleUtil.setStatusBar(this);
/*        if (Build.VERSION.SDK_INT >= 23){
            getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorMain));
        }*/

        //refreshPager();
        //refreshList();
        lv_favorites.addHeaderView(header_favor);

        new HistoryListTask().execute();


        new ListHeaderTask().execute();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("CODE",resultCode+"");
        switch (requestCode){
            case REQUEST_CODE_LOGIN :
                //if (resultCode == LoginActivity.RESULT_CODE_SUCCESS) {
//                    mUserInfo.setUserId(data.getStringExtra("id"));
//                    mUserInfo.setUserName(data.getStringExtra("userName"));
//                    mUserInfo.setSex(data.getStringExtra("sex"));
//                    mUserInfo.setSchool(data.getStringExtra("school"));
                    //isLoggin = true;
                    //refreshInfo();
                    //refreshFavor();
                //}
                break;
            case REQUEST_CODE_DETAIL:
//                if (resultCode == 1){
//                    refreshInfo();
//                    isLoggin = true;
//                }
                new HistoryListTask().execute();
                new ListHeaderTask().execute();
                //refreshFavor();
                break;
            case REQUEST_CODE_EDIT_HEADER:
                new ListHeaderTask().execute();
                break;
            case REQUEST_CODE_EDIT_INFO :
                if (resultCode == 1)
                    refreshInfo();
                break;
            default:
                // 跳转扫描页面返回扫描数据
                IntentResult scanResult = IntentIntegrator.
                        parseActivityResult(requestCode, resultCode, data);
                //  判断返回值是否为空
                if (scanResult.getContents() != null) {
                    //返回条形码数据
                    final String result = scanResult.getContents();
                    Log.d("code", result);
                    //Toast.makeText(this, "扫描成功", Toast.LENGTH_LONG).show();
                    showDetails(result);
                }
                else Toast.makeText(this, "扫描失败！", Toast.LENGTH_SHORT).show();
                break;
        }
        //Toast.makeText(this,requestCode + " " + resultCode,Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEvent(LoginEvent event){
        System.out.println("Login Event");
        refreshInfo();
        isLoggin = true;
    }

    private void upDateTab(final TabHost mTabHost) {
        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            TextView tv = mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextSize(16);
            if (mTabHost.getCurrentTab() == i) {//选中
                tv.setTextColor(this.getResources().getColor(R.color.colorAccent));
            } else {//不选中
                tv.setTextColor(this.getResources().getColor(R.color.colorMain));
            }
        }
        //refreshList();
    }


    @Override
    protected void onResume() {
        super.onResume();
        refreshFavor();
    }

    public void clickScan(View view) {  //扫码搜索
        //扫描操作
        IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
        integrator.initiateScan();
    }

    public void openMenu(View view){
        if (drawerLayout.isDrawerOpen(leftNavigation)){
            drawerLayout.closeDrawer(leftNavigation);
        }else{
            drawerLayout.openDrawer(leftNavigation);
        }
    }

    public void clickSearch(View view){  //输入ISBN号搜索
        String result = et_search.getText().toString();
        System.out.println(result);
        //test
        Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
        intent.putExtra("name",result);
        startActivity(intent);
        //showDetails(result);
    }

    public void showDetails(String isbn){
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra("ISBN",isbn);
        startActivityForResult(intent,REQUEST_CODE_DETAIL);
    }

    public void refreshFavor(){
        new FavorListTask().execute();
    }

    public void refreshInfo(){
        String id = mPreferences.getString("userId","");
        String name = mPreferences.getString("userName","");
        String school = mPreferences.getString("school","江西理工大学");
        //Log.i("NAME",name);
        if (id.length()!=0){
            tv_userId.setText(id);
        } else tv_userId.setText("");
        if (name.length() != 0){
            tv_userName.setText(name);
        }
        else tv_userName.setText("请登录");

    }

    //异步
    private class LogoutTask extends MyHttpTask{

        @Override
        protected String getUrl() {
            return getResources().getString(R.string.url_logout);
        }

        @Override
        protected String getCookie() {
            return mPreferences.getString("cookie","");
        }

        @Override
        protected Map<String, String> getParam() {
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                Log.i("RE",result);
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("code") == 200){
                        Toast.makeText(MainActivity.this,
                                "已退出登录",Toast.LENGTH_SHORT).show();
                        mEditor.putString("cookie","");
                        mEditor.putString("userId","");
                        mEditor.putString("userName","");
                        mEditor.apply();
                        //mUserInfo.clear();
                        isLoggin = false;
                        refreshInfo();
                        refreshFavor();
                        return;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Toast.makeText(MainActivity.this,
                    "错误",Toast.LENGTH_SHORT).show();
        }
    }

    private class LoginTask extends AsyncTask<Integer,Integer,Integer> {

        public final static int RESULT_SUCCESS = 1000;
        public final static int RESULT_EXCEPTION_HTTP = 1001;
        public final static int RESULT_EXCEPTION_JSON = 1002;
        public final static int RESULT_EXCEPTION = 1003;

        @Override
        protected Integer doInBackground(Integer... integers) {
            String cookie = mPreferences.getString("cookie","");
            if (cookie.length() != 0){
                try {
                    URL url = new URL(getResources().getString(R.string.url_login2));
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(5000);
                    conn.addRequestProperty("Cookie",cookie);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String str;
                    while((str = reader.readLine())!= null){
                        sb.append(str);
                    }
                    JSONObject jsonObject = new JSONObject(sb.toString());
                    if (jsonObject.getInt("code") == 200) {
                        mEditor.putString("cookie",cookie);
                        mEditor.putString("userId",jsonObject.getString("id"));
                        mEditor.putString("userName",jsonObject.getString("username"));
                        mEditor.putString("school",jsonObject.getString("school"));
                        mEditor.apply();
                        isLoggin = true;
                        return RESULT_SUCCESS;
                    }
                    else {
                        mEditor.putString("cookie","");
                        mEditor.putString("userId","");
                        mEditor.putString("userName","");
                        mEditor.putString("school","");
                        mEditor.apply();
                        isLoggin = false;
                        return 2;
                    }
                } catch (JSONException e){
                    e.printStackTrace();
                    return RESULT_EXCEPTION_JSON;
                } catch (IOException e) {
                    e.printStackTrace();
                    return RESULT_EXCEPTION_HTTP;
                }
            }
            return RESULT_EXCEPTION;

        }

        public void onPostExecute(Integer result){
            if (result == RESULT_EXCEPTION_HTTP)
                Toast.makeText(MainActivity.this,
                        "网络异常",Toast.LENGTH_SHORT).show();
            refreshFavor();
            refreshInfo();
        }


    }

    private class FavorListTask extends MyHttpTask{


        @Override
        protected void onPostExecute(String result){
            Log.i("FLT","BBB");
            List<FavorBook> list = new ArrayList<FavorBook>();
            //Log.i("RESULT",result);
            if (result != null){
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("code") == 200){
                        JSONArray array = jsonObject.getJSONArray("books");
                        for (int i = 0;i < array.length();i++){
                            JSONObject object = array.getJSONObject(i);
                            String id = object.getString("bookid");
                            String time = object.getString("time");
                            String name = object.getString("bookname");
                            FavorBook favorBook = new FavorBook(id,name,time);
                            list.add(favorBook);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            //因为header和emptyView不能同时设置，这里要用别的方法处理列表为空的情况
            if (list.size() != 0){
                emptyListView1.setVisibility(View.GONE);
            }
            else emptyListView1.setVisibility(View.VISIBLE);
            lv_favorites.setAdapter(
                    new FavorListAdapter(MainActivity.this,list));
        }

        @Override
        protected String getUrl() {
            return getResources().getString(R.string.url_collection_check);
        }

        @Override
        protected String getCookie() {
            return mPreferences.getString("cookie","");
        }

        @Override
        protected Map<String, String> getParam() {
            return null;
        }


    }

    private class ListHeaderTask extends AsyncTask<Integer,Integer,String>{

        @Override
        protected String doInBackground(Integer... integers) {
            SQLHelper.init(getApplicationContext(),new BookLocationDB());
            mBookLocations = SQLHelper.query(BookLocationDB.TABLE_NAME,
                    "select * from " + BookLocationDB.TABLE_NAME
                            + " order by time desc",null);
            String detail = "";
            for (BookLocation bookLocation : mBookLocations) {
                detail = detail + bookLocation.getTitle()
                        + '\n' + bookLocation.getLocation()
                        + '\n';
            }
            return detail;
        }

        @Override
        protected void onPostExecute(String detail){
            if (detail.length() != 0){
                TextView textView = header_favor.findViewById(R.id.tv_detail);
                textView.setText(detail);
                ImageButton imageButton = header_favor.findViewById(R.id.ib_edit);
                imageButton.setVisibility(View.VISIBLE);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,
                                EditHeaderActivity.class);
                        intent.putExtra("list", (Serializable) mBookLocations);
                        startActivityForResult(intent,REQUEST_CODE_EDIT_HEADER);
                    }
                });
            }
            else
            {
                TextView textView = header_favor.findViewById(R.id.tv_detail);
                textView.setText("收藏的藏书记录显示在这里。\n");
                ImageButton imageButton = header_favor.findViewById(R.id.ib_edit);
                imageButton.setVisibility(View.INVISIBLE);
                //header_favor.setVisibility(View.GONE);

            }

        }
    }

    private class HistoryListTask extends AsyncTask<Integer,Integer,List<HistoryBook>>{

        List<HistoryBook> list = new ArrayList<HistoryBook>();

        @Override
        protected List<HistoryBook> doInBackground(Integer... integers) {
            SQLHelper.init(getApplicationContext(),new HistoryDB());
            list = SQLHelper.query(HistoryDB.TABLE_NAME_1,
                    "select * from " + HistoryDB.TABLE_NAME_1 + " order by time desc",null);

            return list;
        }

        @Override
        protected void onPostExecute(List<HistoryBook> list){
            historyListAdapter = new HistoryListAdapter(MainActivity.this,list);
            lv_historyList.setAdapter(historyListAdapter);
        }
    }

    public void test2(View v){
        showDetails("test");
    }

    public void test(View v){
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void test3(View v){
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
