package cc.hydrion.tushusaoma.Bean;

import java.util.Date;

/**
 * Created by Hydrion on 2018/3/1.
 */

public class HistoryBook {
    private String mISBN;
    private String mAuthor;
    private String mTitle;
    private long mTime;

    public HistoryBook(String title,String author,String isbn){
        mTitle = title;
        mAuthor = author;
        mISBN = isbn;
        //getTime获取1970-1-1到当前的毫秒数，以此代表时间
        mTime = new Date().getTime()/1000;
    }

    public void updateTime(){
        mTime = new Date().getTime()/1000;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getAuthor(){
        return mAuthor;
    }

    public String getISBN(){
        return mISBN;
    }

    public long getTime(){
        return mTime;
    }
}
