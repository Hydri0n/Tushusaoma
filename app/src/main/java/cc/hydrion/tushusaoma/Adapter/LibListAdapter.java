package cc.hydrion.tushusaoma.Adapter;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import cc.hydrion.tushusaoma.Activity.MainActivity;
import cc.hydrion.tushusaoma.Bean.BookLocation;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.SQLHelper;
import cc.hydrion.tushusaoma.sql.BookLocationDB;


public class LibListAdapter extends BaseAdapter{



    private List<Map<String,String>> mList;
    private Context mContext;
    private String mBookName;

    public LibListAdapter(Context context,List<Map<String,String>> list,String bookName){
        mList = list;
        mContext = context;
        mBookName = bookName;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = View.inflate(mContext, R.layout.item_lib_list,null);
        TextView tv_location = view.findViewById(R.id.address);
        TextView tv_status = view.findViewById(R.id.status);
        tv_location.setText((String)mList.get(i).get("address"));
        tv_status.setText((String)mList.get(i).get("status"));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final int[] pos = new int[2];
                View popupView = View.inflate(mContext,R.layout.popup_lib,null);
                final TextView tv_button1 = popupView.findViewById(R.id.lib_button1);
                TextView tv_button2 = popupView.findViewById(R.id.lib_button2);

                tv_button1.setOnTouchListener(new RelativeOnTouchListener());
                tv_button2.setOnTouchListener(new RelativeOnTouchListener());
                tv_button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Thread(){
                            public void run(){
                                SQLHelper.init(mContext, new BookLocationDB());
                                BookLocation bookLocation = new BookLocation(
                                        mList.get(i).get("address"),mBookName);
                                SQLHelper.insert(BookLocationDB.TABLE_NAME,bookLocation);
                            }
                        }.start();
                        Toast.makeText(mContext,"已收藏至首页",Toast.LENGTH_SHORT).show();
                    }
                });
                tv_button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = "书名：" + mBookName + '\n' +
                                "位置：" + mList.get(i).get("address") + '\n'
                                + "状态：" + mList.get(i).get("status");
                        //调用系统剪贴板
                        ClipboardManager clipboardManager =
                                (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboardManager.setText(data);
                        Toast.makeText(mContext,"已复制",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                PopupWindow popupWindow = new PopupWindow(popupView,240,300);
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.update();
                popupWindow.showAsDropDown(view,view.getWidth(),
                        -view.getHeight()+10);
            }
        });
        return view;
    }

    private class RelativeOnTouchListener implements View.OnTouchListener {

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN :
                    //(TextView)view.setText
                    view.setBackground(new ColorDrawable(mContext.getColor(R.color.grayText)));break;
                case MotionEvent.ACTION_CANCEL :
                case MotionEvent.ACTION_UP :
                    view.setBackground(null);break;
            }
            //若返回FALSE则只响应按下的操作
            return false;
        }
    }
}
