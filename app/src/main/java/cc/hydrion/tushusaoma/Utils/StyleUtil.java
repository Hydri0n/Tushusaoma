package cc.hydrion.tushusaoma.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;

import cc.hydrion.tushusaoma.R;

/**
 * Created by Hydrion on 2018/2/27.
 */

public class StyleUtil {
    public static void setStatusBar(Activity activity){
        if (Build.VERSION.SDK_INT >= 23){
            activity.getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        else {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.colorMain));
        }
    }
}
