package cc.hydrion.tushusaoma.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.hydrion.tushusaoma.Adapter.CommentListAdapter;
import cc.hydrion.tushusaoma.Adapter.MyCommentListAdapter;
import cc.hydrion.tushusaoma.Bean.Comment;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.MyHttpTask;
import cc.hydrion.tushusaoma.Utils.StyleUtil;

public class MyCommentsActivity extends AppCompatActivity {

    String cookie;

    ImageButton mImageButton;
    ListView lv_comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comments);

        StyleUtil.setStatusBar(this);


        cookie = getSharedPreferences("user",MODE_PRIVATE)
                .getString("cookie","");
        mImageButton = findViewById(R.id.backButton);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });
        lv_comments = findViewById(R.id.lv_comment);
        lv_comments.setEmptyView(findViewById(R.id.empty_list));

        new MyCommentTask().execute();
    }

    @Override
    public void onBackPressed(){
        finishActivity();
    }

    public void finishActivity(){
        finish();
    }

    class MyCommentTask extends MyHttpTask {

        @Override
        protected String getUrl() {
            return getApplicationContext().getResources().getString(R.string.url_comment_self);
        }

        @Override
        protected String getCookie() {
            return cookie;
        }

        @Override
        protected Map<String, String> getParam() {
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            List<Comment> list = new ArrayList<Comment>();
            //Log.i("RESULT", result);
            try {
                JSONObject jsonObject = new JSONObject(result);
                if (jsonObject.getInt("code") == 200) {
                    JSONArray array = jsonObject.getJSONArray("comments");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String content = object.getString("content");
                        String time = object.getString("time");
                        String bookName = object.getString("bookname");
                        Comment comment = new Comment(content, time, null,bookName);
                        list.add(comment);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            lv_comments.setAdapter(new MyCommentListAdapter(MyCommentsActivity.this,
                    list));
        }
    }
}
