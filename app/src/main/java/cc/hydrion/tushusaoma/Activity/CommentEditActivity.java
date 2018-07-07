package cc.hydrion.tushusaoma.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.MyHttpTask;
import cc.hydrion.tushusaoma.Utils.StyleUtil;

public class CommentEditActivity extends AppCompatActivity {

    public final static int RESULT_CODE_COMPLETE = 1;
    public final static int RESULT_CODE_QUIT = 0;

    EditText mEditText;
    String content;
    String isbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_edit);

        StyleUtil.setStatusBar(this);

        isbn = getIntent().getStringExtra("isbn");
        mEditText = findViewById(R.id.editText);
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quitActivity();
            }
        });
    }

    @Override
    public void onBackPressed(){
        quitActivity();
    }

    public void finishActivity(){
        setResult(RESULT_CODE_COMPLETE);
        finish();
    }

    public void quitActivity(){
        setResult(RESULT_CODE_QUIT);
        finish();
    }

    public void commit(View view){
        content = mEditText.getText().toString();
        if (content.length() != 0){
            new CommentCommitTask().execute();
        }
        else Toast.makeText(CommentEditActivity.this,
                "未填写任何内容！",Toast.LENGTH_SHORT).show();
    }

    class CommentCommitTask extends MyHttpTask{

        @Override
        protected String getUrl() {
            return getResources().getString(R.string.url_comment_deliver);
        }

        @Override
        protected String getCookie() {
            return getSharedPreferences("user",MODE_PRIVATE)
                    .getString("cookie","");
        }

        @Override
        protected Map<String, String> getParam() {
            Map<String,String> param = new HashMap<String,String>();
            param.put("content",content);
            param.put("isbn",isbn);
            return param;
        }

        @Override
        protected void onPostExecute(String result){
            //Log.i("RE",result);
            if (result != null){
                try{
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("code") == 200) {
                        Toast.makeText(CommentEditActivity.this,
                                "已发表",Toast.LENGTH_SHORT).show();
                        finishActivity();
                    }
                } catch (JSONException e){
                }
            }
            else {
                Toast.makeText(CommentEditActivity.this,
                        "评论失败",Toast.LENGTH_SHORT).show();
                quitActivity();
            }
        }
    }
}