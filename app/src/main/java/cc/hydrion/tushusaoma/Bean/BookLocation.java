package cc.hydrion.tushusaoma.Bean;

import java.io.Serializable;
import java.net.PortUnreachableException;
import java.util.Date;


public class BookLocation implements Serializable{
    private String location;
    private String title;
    private long time;

    public BookLocation(String location,String title){
        this.location = location;
        this.title = title;
        time = new Date().getTime()/1000;
    }

    public String getLocation(){
        return location;
    }

    public String getTitle(){
        return title;
    }

    public Long getTime(){
        return time;
    }
}
