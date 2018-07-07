package cc.hydrion.tushusaoma.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cc.hydrion.tushusaoma.Activity.MainActivity;
import cc.hydrion.tushusaoma.Bean.FavorBook;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.TimeTransformer;


public class FavorListAdapter extends BaseAdapter{

    private List<FavorBook> mList;
    private Context mContext;

    public FavorListAdapter(Context context, List<FavorBook> list){
        mList = list;
        mContext = context;
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
        view = View.inflate(mContext,R.layout.item_favor,null);
        try{
            TextView tv_name = view.findViewById(R.id.tv_bookName);
            TextView tv_time = view.findViewById(R.id.tv_time);
            tv_name.setText(mList.get(i).getTitle());
            tv_time.setText(TimeTransformer.transfrom1(mList.get(i).getTime()));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) mContext;
                activity.showDetails(mList.get(i).getISBN());
            }
        });
        return view;
    }

}
