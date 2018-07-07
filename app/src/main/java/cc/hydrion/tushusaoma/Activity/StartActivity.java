package cc.hydrion.tushusaoma.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import cc.hydrion.tushusaoma.R;

public class StartActivity extends Activity {

    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPreferences = getSharedPreferences("app",MODE_PRIVATE);
        Boolean isFirstOpen = mPreferences.getBoolean("firstOpen",true);
        //isFirstOpen = true;
        if (isFirstOpen) {
//            mEditor = mPreferences.edit();
//            mEditor.putBoolean("firstOpen",false);
//            mEditor.apply();
            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                enterHomeActivity();
            }
            }, 1200);
    }

    private void enterHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
