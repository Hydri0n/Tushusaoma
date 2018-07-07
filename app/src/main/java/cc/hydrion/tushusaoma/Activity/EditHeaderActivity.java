package cc.hydrion.tushusaoma.Activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cc.hydrion.tushusaoma.Adapter.EditHeaderListAdapter;
import cc.hydrion.tushusaoma.Bean.BookLocation;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.SQLHelper;
import cc.hydrion.tushusaoma.Utils.StyleUtil;
import cc.hydrion.tushusaoma.sql.BookLocationDB;

public class EditHeaderActivity extends AppCompatActivity {

    private ListView mListView;
    List<BookLocation> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_header);

        StyleUtil.setStatusBar(this);

        mListView = findViewById(R.id.listView);
        ImageButton backButton = findViewById(R.id.edit_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });

        mList = (List<BookLocation>) getIntent().getSerializableExtra("list");
        mListView.setAdapter(new EditHeaderListAdapter(EditHeaderActivity.this,
                mList));
    }

    @Override
    public void onBackPressed(){
        finishActivity();
    }

    public void finishActivity(){
        setResult(0);
        finish();
    }

    public void refresh(){
        new EditHeaderTask().execute();
    }

    private class EditHeaderTask extends AsyncTask<Integer,Integer,List<BookLocation>>{

        @Override
        protected List<BookLocation> doInBackground(Integer... integers) {
            SQLHelper.init(getApplicationContext(),new BookLocationDB());
            mList = SQLHelper.query(BookLocationDB.TABLE_NAME,
                    "select * from " + BookLocationDB.TABLE_NAME
                            + " order by time desc",null);
            return mList;
        }

        @Override
        protected void onPostExecute(List<BookLocation> list){
            mListView.setAdapter(new EditHeaderListAdapter(EditHeaderActivity.this,
                    list));
            Toast.makeText(EditHeaderActivity.this,"已删除",
                    Toast.LENGTH_SHORT).show();
        }


    }
}
