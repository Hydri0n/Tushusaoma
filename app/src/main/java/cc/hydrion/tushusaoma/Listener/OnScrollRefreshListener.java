package cc.hydrion.tushusaoma.Listener;

import android.view.View;
import android.widget.AbsListView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

import cc.hydrion.tushusaoma.Bean.SearchBook;

/**
 * Created by Hydrion on 2018/4/22.
 */

public class OnScrollRefreshListener implements AbsListView.OnScrollListener {

    private boolean isLoading;

    private int currentIndex = 0;
    private int lastItem;
    private int totalItemCount;

    private View footer;
    private OnloadDataListener mListener;
    public OnScrollRefreshListener(View footer) {
        this.footer = footer;
    }

    public void setOnLoadDataListener(OnloadDataListener listener) {
        mListener = listener;
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (!isLoading && lastItem == totalItemCount && scrollState == SCROLL_STATE_IDLE) {
            //显示加载更多
            footer.setVisibility(View.VISIBLE);
            new Thread(){
                @Override
                public void run(){
                    isLoading = true;
                    mListener.onLoadData();
                    isLoading = false;

                }
            }.start();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        lastItem = firstVisibleItem + visibleItemCount;
        this.totalItemCount = totalItemCount;
    }

    public interface OnloadDataListener {
        void onLoadData();
    }
}
