package cc.hydrion.tushusaoma.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cc.hydrion.tushusaoma.Activity.MainActivity;
import cc.hydrion.tushusaoma.Bean.HistoryBook;
import cc.hydrion.tushusaoma.Entry.HistoryBookEntry;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.SQLHelper;
import cc.hydrion.tushusaoma.sql.HistoryDB;


public class HistoryListAdapter extends BaseAdapter{

    private List<HistoryBook> mList;
    private Context mContext;

    public HistoryListAdapter(Context context,List<HistoryBook> list){
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

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = View.inflate(mContext,R.layout.item_history_book,null);
        TextView tv_title = view.findViewById(R.id.history_book_title);
        TextView tv_author = view.findViewById(R.id.history_book_author);
        tv_title.setText(mList.get(i).getTitle());
        tv_author.setText(mList.get(i).getAuthor());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    public void run(){
                        SQLHelper.init(mContext,new HistoryDB());
                        HistoryBook historyBook = mList.get(i);
                        historyBook.updateTime();
                        SQLHelper.update(HistoryDB.TABLE_NAME_1,historyBook,
                                HistoryBookEntry.COLEUM_NAME_ISBN + "=?",
                                new String[]{historyBook.getISBN()});
                    }
                }.start();
                MainActivity activity = (MainActivity) mContext;
                activity.showDetails(mList.get(i).getISBN());
            }
        });
        return view;
    }

}
