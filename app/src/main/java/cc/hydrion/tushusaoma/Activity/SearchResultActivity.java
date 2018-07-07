package cc.hydrion.tushusaoma.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.hydrion.tushusaoma.Adapter.SearchBookAdapter;
import cc.hydrion.tushusaoma.Bean.SearchBook;
import cc.hydrion.tushusaoma.Listener.OnScrollRefreshListener;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.MyHttpTask;
import cc.hydrion.tushusaoma.Utils.StyleUtil;

/**
 * Created by Hydrion on 2018/4/19.
 */

public class SearchResultActivity extends Activity implements OnScrollRefreshListener.OnloadDataListener{

    final static int ITEM_COUNT_PER_PAGE = 10;
    ListView mListView;
    ImageButton backButton;
    private List<SearchBook.BooksBean> data = new ArrayList<>();
    SearchBookAdapter mAdapter;
    View footer;
    int currentIndex = 0;
    String bookName;
    MyAsyncTask mTask;
    private ImageLoader mImageLoader = ImageLoader.getInstance();
    DisplayImageOptions options;
    ProgressDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        StyleUtil.setStatusBar(this);

        bookName = getIntent().getStringExtra("name");


        mListView = findViewById(R.id.listView);
        backButton = findViewById(R.id.lib_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initImageLoader();
        footer = LayoutInflater.from(this).inflate(R.layout.footer_search_book,null);
        OnScrollRefreshListener listener = new OnScrollRefreshListener(footer);
        listener.setOnLoadDataListener(this);
        mListView.setOnScrollListener(listener);


        mTask = new MyAsyncTask();
        if (currentIndex == 0){
            dialog = ProgressDialog.show(SearchResultActivity.this,
                    "提示","正在搜索...",true);
        }
        mTask.execute();
    }

    @Override
    public void onLoadData() {
//        loadData();
//        showListView(data);
        mTask = new MyAsyncTask();
        mTask.execute();
    }

    private void loadData(){
        String result = getBookData();
        Gson gson = new Gson();
        SearchBook searchBook = gson.fromJson(result, SearchBook.class);
        if (searchBook.getTotal() != 0){
            data.addAll(searchBook.getBooks());
            currentIndex += ITEM_COUNT_PER_PAGE;
        }

    }

    private void initImageLoader(){
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY-2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .build();
        mImageLoader.init(config);

    }

    private String getBookData(){
        String result = null;
        String strUrl = "https://api.douban.com/v2/book/search?q="
                + bookName + "&start=" + currentIndex + "&count=" + ITEM_COUNT_PER_PAGE;
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = reader.readLine())!= null){
                sb.append(str);
            }
            result = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void showListView(List<SearchBook.BooksBean> data) {
        if (mAdapter == null) {
            footer.setVisibility(View.GONE);
            mListView.addFooterView(footer);
            mAdapter = new SearchBookAdapter(this,data);
            mListView.setAdapter(mAdapter);
        } else {
            this.data = data;
            mAdapter.notifyDataSetChanged();
            footer.setVisibility(View.GONE);
        }
    }


    class MyAsyncTask extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... integers) {
            loadData();
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            if (dialog.isShowing()) dialog.dismiss();
            showListView(data);
        }
    }

}
