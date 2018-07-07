package cc.hydrion.tushusaoma.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.hydrion.tushusaoma.Adapter.CommentListAdapter;
import cc.hydrion.tushusaoma.Bean.Comment;
import cc.hydrion.tushusaoma.Bean.FavorBook;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.MyHttpTask;
import cc.hydrion.tushusaoma.Utils.StyleUtil;

public class CommentActivity extends AppCompatActivity {

    private final static int REQUEST_CODE_EDIT = 1000;

    private ListView lv_comment;
    private String cookie;
    private String isbn;
    private ImageButton backButton;
    //private TextView tv_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        StyleUtil.setStatusBar(this);


        isbn = getIntent().getStringExtra("isbn");
        cookie = getSharedPreferences("user",MODE_PRIVATE).getString("cookie","");

        lv_comment = findViewById(R.id.lv_comment);
        lv_comment.setEmptyView(findViewById(R.id.empty_list));
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });
        //tv_add = findViewById(R.id.tv_add);
        new LoadCommentTask().execute();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_EDIT:
                if (resultCode == LoginActivity.RESULT_CODE_SUCCESS) {
                    new LoadCommentTask().execute();
                }
                break;
        }
    }



    @Override
    public void onBackPressed(){
        finishActivity();
    }

    public void finishActivity(){
        finish();
    }

    public void addComment(View view){
        Intent intent = new Intent(CommentActivity.this,CommentEditActivity.class);
        intent.putExtra("isbn",isbn);
        startActivityForResult(intent,REQUEST_CODE_EDIT);
    }

    class LoadCommentTask extends MyHttpTask{

        @Override
        protected String getUrl() {
            return getApplicationContext().getResources().getString(R.string.url_comment_book);
        }

        @Override
        protected String getCookie() {
            return cookie;
        }

        @Override
        protected Map<String, String> getParam() {
            Map<String,String> param = new HashMap<String,String>();
            param.put("isbn",isbn);
            return param;
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
                        String name = object.getString("authorid");
                        Comment comment = new Comment(content, time, name ,null);
                        list.add(comment);
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            lv_comment.setAdapter(new CommentListAdapter(CommentActivity.this,
                    list));
        }
    }
}
