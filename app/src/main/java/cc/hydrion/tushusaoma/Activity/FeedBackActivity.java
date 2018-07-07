package cc.hydrion.tushusaoma.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.StyleUtil;

public class FeedBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        StyleUtil.setStatusBar(this);

        ImageButton backButton = findViewById(R.id.fb_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });
    }

    @Override
    public void onBackPressed(){
        finishActivity();
    }

    public void finishActivity(){
        finish();
    }
}
