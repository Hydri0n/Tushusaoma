package cc.hydrion.tushusaoma.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cc.hydrion.tushusaoma.Bean.Comment;
import cc.hydrion.tushusaoma.R;


public class CommentListAdapter extends BaseAdapter{

    private List<Comment> mList;
    private Context mContext;

    class ViewHolder{
        public TextView tv_name;
        public TextView tv_content;
        public TextView tv_time;
    }

    public CommentListAdapter(Context context, List<Comment> list){
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = View.inflate(mContext, R.layout.item_comment,null);
            viewHolder.tv_name = view.findViewById(R.id.tv_bookName);
            viewHolder.tv_content = view.findViewById(R.id.tv_content);
            viewHolder.tv_time = view.findViewById(R.id.tv_time);
            view.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder) view.getTag();
        viewHolder.tv_name.setText(mList.get(i).getAuthorId());
        viewHolder.tv_content.setText(mList.get(i).getContent());
        viewHolder.tv_time.setText(mList.get(i).getTime());

        return view;
    }
}
