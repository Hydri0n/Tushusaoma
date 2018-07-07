package cc.hydrion.tushusaoma.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import cc.hydrion.tushusaoma.R;


public class InfoListAdapter extends BaseAdapter {

    private Context mContext;
    private String[] items;

    public InfoListAdapter(Context context){
        mContext = context;
        items = context.getResources().getStringArray(R.array.info_list);
    }


    @Override
    public int getCount() {
        return items.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_edit_list,null);
        TextView left_text = view.findViewById(R.id.left_text);
        EditText right_text = view.findViewById(R.id.right_text);

        return view;
    }
}
