package cc.hydrion.tushusaoma.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import cc.hydrion.tushusaoma.Activity.EditHeaderActivity;
import cc.hydrion.tushusaoma.Bean.BookLocation;
import cc.hydrion.tushusaoma.Entry.BookLocationEntry;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.SQLHelper;
import cc.hydrion.tushusaoma.sql.BookLocationDB;

public class EditHeaderListAdapter extends BaseAdapter {

    private Context mContext;
    private List<BookLocation> mList;

    public EditHeaderListAdapter(Context context,List<BookLocation> list){
        mContext = context;
        mList = list;
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
        view = View.inflate(mContext, R.layout.item_edit_header_list,null);
        TextView tv_title = view.findViewById(R.id.tv_title);
        TextView tv_location = view.findViewById(R.id.tv_location);
        tv_title.setText(mList.get(i).getTitle());
        tv_location.setText(mList.get(i).getLocation());
        ImageButton imageButton = view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLHelper.init(mContext,new BookLocationDB());
                SQLHelper.delete(BookLocationDB.TABLE_NAME,
                        BookLocationEntry.COLEUM_NAME_LOCATION + "=?",
                        new String[]{mList.get(i).getLocation()});
                EditHeaderActivity activity = (EditHeaderActivity)mContext;
                activity.refresh();
            }
        });
        return view;
    }
}
