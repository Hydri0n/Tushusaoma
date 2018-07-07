package cc.hydrion.tushusaoma.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cc.hydrion.tushusaoma.Adapter.GuideViewPagerAdapter;
import cc.hydrion.tushusaoma.R;

public class WelcomeGuideActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager vp;
    private GuideViewPagerAdapter adapter;
    private List<View> views;

    private static final int[] pics = { R.layout.guide_1,
            R.layout.guide_2, R.layout.guide_3 ,R.layout.guide_4};

    private ImageView[] dots;

    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome_guide);


        views = new ArrayList<View>();

        // 初始化引导页视图列表
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);

            if (i == pics.length - 1) {
                view.setTag("enter");
                view.setOnClickListener(this);
            }

            views.add(view);
        }


        vp = (ViewPager) findViewById(R.id.vp_guide);
        // 初始化adapter
        adapter = new GuideViewPagerAdapter(views);
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new PageChangeListener());

        initDots();
    }


    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[pics.length];

        // 循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            // 得到一个LinearLayout下面的每一个子元素
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(false);// 都设为灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);// 设置位置tag，方便取出与当前位置对应
        }

        currentIndex = 0;
        dots[currentIndex].setEnabled(true); // 设置为白色，即选中状态

    }

    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        vp.setCurrentItem(position);
    }

    /**
     * 设置当前指示点
     *
     * @param position
     */
    private void setCurDot(int position) {
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
    }

    @Override
    public void onClick(View view) {

        if (view.getTag().equals("enter")) {
            enterMainActivity();
            return;
        }
        int position = (Integer) view.getTag();
        setCurView(position);
        setCurDot(position);
    }


    private void enterMainActivity() {
        SharedPreferences preferences = getSharedPreferences("app",MODE_PRIVATE);
        if (preferences.getBoolean("firstOpen",true)){
            Intent intent = new Intent(WelcomeGuideActivity.this,
                    StartActivity.class);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("firstOpen",false);
            editor.apply();
            startActivity(intent);
            finish();
        }
        else {
            finish();
        }

    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            setCurDot(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
