package cc.hydrion.tushusaoma.Bean;

import java.util.Date;

/**
 * Created by Hydrion on 2018/3/1.
 */

public class FavorBook {
    private String mISBN;
    private String mTitle;
    private String mTime;

    public FavorBook(String isbn,String title,String time){
        mTitle = title;
        mISBN = isbn;
        mTime = time;
    }

    public String getTitle(){
        return mTitle;
    }


    public String getISBN(){
        return mISBN;
    }

    public String getTime(){
        return mTime;
    }
}
