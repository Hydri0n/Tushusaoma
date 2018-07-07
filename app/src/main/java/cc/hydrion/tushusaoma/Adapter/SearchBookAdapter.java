package cc.hydrion.tushusaoma.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import cc.hydrion.tushusaoma.Activity.DetailActivity;
import cc.hydrion.tushusaoma.Activity.SearchResultActivity;
import cc.hydrion.tushusaoma.Bean.SearchBook;
import cc.hydrion.tushusaoma.R;
import cc.hydrion.tushusaoma.Utils.ViewHolder;

/**
 * Created by Hydrion on 2018/4/22.
 */

public class SearchBookAdapter extends BaseAdapter{

    private List<SearchBook.BooksBean> data;
    private Context mContext;

    public SearchBookAdapter(Context context, List<SearchBook.BooksBean> data) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getHolder(convertView,parent,position, R.layout.item_search_book);
        setData(holder,data.get(position));
        View view = holder.getConvertView();
        final String isbn = data.get(position).getIsbn13();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailActivity.class);
                intent.putExtra("ISBN",isbn);
                SearchResultActivity activity = (SearchResultActivity) mContext;
                activity.startActivityForResult(intent,0);
            }
        });
        return view;
    }

    public void setData(ViewHolder holder, SearchBook.BooksBean t) {
        String authors = "";
        for (String author : t.getAuthor()){
            authors = authors + author + " ";
        }
        holder.setText(R.id.bookName, t.getTitle())
                .setText(R.id.publisher, t.getPublisher())
        .setText(R.id.date,t.getPubdate())
        .setText(R.id.author,authors)
        .setText(R.id.points,t.getRating().getAverage())
        .setImage(R.id.imageView,t.getImage());
    }
}
