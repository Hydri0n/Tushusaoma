package cc.hydrion.tushusaoma.Activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import cc.hydrion.tushusaoma.Bean.HistoryBook;
import cc.hydrion.tushusaoma.Bean.SearchBook;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.CheckOnline;
import cc.hydrion.tushusaoma.Utils.MyHttpTask;
import cc.hydrion.tushusaoma.Utils.SQLHelper;
import cc.hydrion.tushusaoma.Utils.StreamTools;
import cc.hydrion.tushusaoma.Utils.StyleUtil;
import cc.hydrion.tushusaoma.Bean.UtilsBookInfo;
import cc.hydrion.tushusaoma.sql.HistoryDB;

import static cc.hydrion.tushusaoma.Activity.MainActivity.REQUEST_CODE_LOGIN;

public class DetailActivity extends AppCompatActivity {


    private String isbn10;  //十位的ISBN码
    private String title;
    private String[] detaillist;
    private String[] detailchild = {"暂无","暂无","暂无"};

    private UtilsBookInfo bookInfo;
    private ImageView iv_bookcover;
    private TextView tv_name;
    private TextView tv_average;
    private TextView tv_author;
    private TextView tv_price;
    private TextView tv_pubdate;
    private ExpandableListView listView;
    private ImageButton backButton;
    private SharedPreferences mPreferences;
    private int resultCode = 0;


    final static String TAG = "DetailPage";

    private final int MESSAGEFIND = 1;
    private final int MESSAGENOFIND = 0;
    private final int MESSAGEEXPTION = 2;
    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case MESSAGEFIND:
                    //做测试按钮的时候发现运行到此便会闪退，改成StringBuilder后可以解决
                    if (isbn.equals("test")) {
                        StringBuilder content = (StringBuilder) msg.obj;
                        parseJSONWithJSONObject(content.toString());
                    } else {
                        String content = (String) msg.obj;
                        parseJSONWithJSONObject(content);
                    }
                    setBookCoverImage(bookInfo.getImage());

                    isbn10 = bookInfo.getIsbn10();
                    if (!bookInfo.getSummary().equals(""))
                        detailchild[0] = bookInfo.getSummary();
                    if (!bookInfo.getCatalog().equals(""))
                        detailchild[1] = bookInfo.getCatalog();
                    if (!bookInfo.getAuthor_intro().equals(""))
                        detailchild[2] = bookInfo.getAuthor_intro();
                    if (!bookInfo.getAuthor().equals(""))
                        tv_author.setText(bookInfo.getAuthor());
                    if (!bookInfo.getPubdate().equals(""))
                        tv_pubdate.setText(bookInfo.getPubdate());
                    if (!bookInfo.getTitle().equals(""))
                        tv_name.setText(bookInfo.getTitle());
                    if (!bookInfo.getAverage().equals(""))
                        tv_average.setText(bookInfo.getAverage()
                                + "（共" + bookInfo.getAverage_num() + "人评分）");
                    if (!bookInfo.getPrice().equals(""))
                        tv_price.setText(bookInfo.getPrice());

                    //上传访问记录
                    new BookLogTask().execute();
                    break;
                case MESSAGENOFIND:
                    Toast.makeText(getApplicationContext(), "没有找到结果！", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case MESSAGEEXPTION:
                    Toast.makeText(getApplicationContext(), "网络错误", Toast.LENGTH_SHORT).show();
                    finish();
            }
        }
    };

    String isbn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorMain));
        //StyleUtil.setStatusBar(this);

        mPreferences = getSharedPreferences("user",MODE_PRIVATE);
        String s = mPreferences.getString("cookie","");
        Log.i(TAG,s);



        iv_bookcover =  findViewById(R.id.imageView);
        tv_name = findViewById(R.id.textView6);
        tv_author = findViewById(R.id.textView7);
        tv_average = findViewById(R.id.textView9);
        tv_pubdate = findViewById(R.id.textView8);
        tv_price =  findViewById(R.id.textView10);
        backButton = findViewById(R.id.detail_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });

        //从strings.xml中获取字符串数组
        detaillist = getResources().getStringArray(R.array.detail_list);
        listView = findViewById(R.id.listview1);
        listView.setAdapter(new MyExpandableListViewAdapter());

        SearchBook.BooksBean booksBean = (SearchBook.BooksBean) getIntent().getSerializableExtra("bean");
        if (booksBean != null){
            loadDataFromBean(booksBean);
            return;
        }
        isbn = getIntent().getStringExtra("ISBN");

        Log.i(TAG,isbn);
        final ProgressDialog dialog = ProgressDialog.show(DetailActivity.this,
                "提示","正在获取图书信息",true);
        //TEST:
        //判断isbn是否为test
        if (!isbn.equals("test")) {
            new Thread() {
                @Override
                public void run() {
                    InputStream in;
                    try {
                        String path = "https://api.douban.com/v2/book/isbn/" + isbn;
                        URL url = null;
                        url = new URL(path);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        conn.setRequestMethod("GET");

                        conn.setConnectTimeout(5000);

                        int code = conn.getResponseCode();
                        if (code == 200) {
                            in = conn.getInputStream();
                            //读出网站源码
                            String content = StreamTools.readStream(in);//                        Thread.sleep(5000);
                            //                        tv_show.setText(content);

                            in.close();
                            //创建message对象
                            Message msg = new Message();
                            msg.what = MESSAGEFIND;
                            msg.obj = content;
                            //向主线程发送消息
                            handler.sendMessage(msg);
                        } else {
                            Message msg = new Message();
                            msg.what = MESSAGENOFIND;
                            handler.sendMessage(msg);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Message msg = new Message();
                        msg.what = MESSAGEEXPTION;
                        handler.sendMessage(msg);
                    }
                }
            }.start();
        } else {
            new Thread(){
                @Override
                public void run(){
                    Log.i(TAG,"Else");

                    StringBuilder stringBuilder = new StringBuilder();
                    try {
                        //获取assets资源管理器
                        AssetManager assetManager = getBaseContext().getAssets();
                        //通过管理器打开文件并读取
                        BufferedReader bf = new BufferedReader(new InputStreamReader(
                                assetManager.open("test.json")));
                        String line;
                        while ((line = bf.readLine()) != null) {
                            stringBuilder.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Message msg = new Message();
                    msg.what = MESSAGEFIND;
                    msg.obj = stringBuilder;
                    //向主线程发送消息
                    handler.sendMessage(msg);
                }
            }.start();
        }
        dialog.dismiss();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_LOGIN:
                if (resultCode == LoginActivity.RESULT_CODE_SUCCESS) {
                    this.resultCode = 1;
                }
                break;
        }
    }

    @Override
    public void onBackPressed(){
        finishActivity();
    }

    private void finishActivity(){
        setResult(resultCode);
        finish();
    }

    private void loadDataFromBean(SearchBook.BooksBean bean){
        setBookCoverImage(bean.getImage());
        detailchild[0] = bean.getSummary();
        detailchild[1] = bean.getCatalog();
        detailchild[2] = bean.getAuthor_intro();
        String authors = "";
        for (String author : bean.getAuthor()){
            authors = authors + author + " ";
        }
        tv_author.setText(authors);
        tv_pubdate.setText(bean.getPubdate());
        tv_name.setText(bean.getTitle());
        tv_average.setText(bean.getRating().getAverage()
                + "（共" + bean.getRating().getNumRaters() + "人评分）");
        tv_price.setText(bean.getPrice());

        new BookLogTask().execute();
    }

    private class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return 3;
        }

        @Override
        public int getChildrenCount(int i) {
            return 1;
        }

        @Override
        public Object getGroup(int i) {
            return detaillist[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return detailchild[i];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(DetailActivity.this);
            textView.setText(detaillist[i]);
            textView.setTextSize(22);
            textView.setPadding(100,25,0,25);
            return  textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(DetailActivity.this);
            textView.setTextSize(14);
            textView.setPadding(4,2,2,4);
            textView.setText(detailchild[i]);
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }

    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONObject obj = new JSONObject(jsonData);

            //将嵌套的JSON数据取出来
            JSONObject average = obj.getJSONObject("rating");
            JSONObject images = obj.getJSONObject("images");

            //解析数组
            JSONArray authors = obj.getJSONArray("author");
            String author = "";
            for (int i = 0;i < authors.length();i++)
                author += authors.getString(i) + " ";


            bookInfo = new UtilsBookInfo();
            title = obj.getString("title");
            bookInfo.setTitle(obj.getString("title"));
            bookInfo.setAuthor(author);
            bookInfo.setPubdate(obj.getString("pubdate"));
            bookInfo.setAuthor_intro(obj.getString("author_intro"));
            bookInfo.setSummary(obj.getString("summary"));
            bookInfo.setAverage(average.getString("average"));
            bookInfo.setAverage_num(average.getInt("numRaters"));
            bookInfo.setPrice(obj.getString("price"));
            bookInfo.setCatalog(obj.getString("catalog"));
            bookInfo.setImage(images.getString("large"));
            bookInfo.setIsbn10(obj.getString("isbn10"));

            //把搜索记录存入数据库
            new Thread(){
                public void run(){
                    SQLHelper.init(getApplicationContext(),new HistoryDB());
                    HistoryBook historyBook = new HistoryBook(bookInfo.getTitle(),
                            bookInfo.getAuthor(),
                            isbn);
                    SQLHelper.insert(HistoryDB.TABLE_NAME_1,historyBook);
                    Log.i(TAG,"INSERTED");
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setBookCoverImage(final String path){
        if (isbn.equals("test"))
            return;
        new Thread(){
            @Override
            public void run() {
                try{
                    //创建URL 对象指定我们要访问的网址
                    URL url = new URL(path);
                    //拿到HttpURLConnection 对象 用于发送或者接收数据
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //设置发送请求
                    conn.setRequestMethod("GET");
                    //设置请求超时时间
                    conn.setConnectTimeout(5000);
                    //获取服务器返回状态码
                    int code = conn.getResponseCode();
                    //如果code == 200 说明请求成功
                    if(code == 200) {
                        //获取服务器返回数据 是以流的形式返回的
                        InputStream in = conn.getInputStream();

                        final Bitmap bitmap = BitmapFactory.decodeStream(in);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                iv_bookcover.setImageBitmap(bitmap);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    //对接图书馆系统
    public void link2Lib(View v){
        Intent intent = new Intent();
        intent.setClass(DetailActivity.this,LibActivity.class);
        //TEST:

        if (!isbn.equals("test")) {
            intent.putExtra("isbn",isbn);
            intent.putExtra("isbn10",isbn10);
        } else {
            intent.putExtra("isbn","9787121259586");
            intent.putExtra("isbn10","7121259586");
        }
        String[] title2 = title.split("\\(|（");
        Log.i(TAG,title2[0]);
        intent.putExtra("title",title2[0]);
        startActivity(intent);
    }

    public void collection(View view){
        new CheckOnline(DetailActivity.this, new CheckOnline.CallBack() {
            @Override
            public void onResult(int code) {
                if (code == 200){
                    new CollectTask().execute();
                }
                else {
                    Intent intent = new Intent(DetailActivity.this,LoginActivity.class);
                    startActivityForResult(intent,REQUEST_CODE_LOGIN);
                }
            }
        }).check();
    }

    public void comment(View view){
        new CheckOnline(DetailActivity.this, new CheckOnline.CallBack() {
            @Override
            public void onResult(int code) {
                if (code == 200){
                    Intent intent = new Intent(DetailActivity.this,CommentActivity.class);
                    intent.putExtra("isbn",isbn);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(DetailActivity.this,LoginActivity.class);
                    startActivityForResult(intent,REQUEST_CODE_LOGIN);
                }
            }
        }).check();
    }

    class BookLogTask extends MyHttpTask{

        @Override
        protected String getUrl() {
            return getResources().getString(R.string.url_book);
        }

        @Override
        protected String getCookie() {
            return "";
        }

        @Override
        protected Map<String, String> getParam() {
            Map<String,String> param = new HashMap<>();
            param.put("isbn",isbn);
            //String sTitle = title.replaceAll("","");
            param.put("bookname",title);
            return param;
        }

        @Override
        protected void onPostExecute(String result){
            if (result != null) Log.d(TAG,"上传完成");
        }
    }

    class CollectTask extends MyHttpTask{

        @Override
        protected String getUrl() {
            return getResources().getString(R.string.url_collection);
        }

        @Override
        protected String getCookie() {

            return mPreferences.getString("cookie","");
        }

        @Override
        protected Map<String, String> getParam() {
            Map<String,String> param = new HashMap<>();
            param.put("isbn",isbn);
            return param;
        }

        @Override
        protected void onPostExecute(String result){
            //Log.d(TAG,result);
            if (result != null){
                try{
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("code") == 200) {
                        Toast.makeText(DetailActivity.this,"已收藏",Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e){
                }
            }
            else {
                Toast.makeText(DetailActivity.this,"收藏失败",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
