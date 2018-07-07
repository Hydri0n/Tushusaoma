package cc.hydrion.tushusaoma.application;

import android.app.Application;

/**
 * Created by Hydrion on 2018/3/3.
 */

public class MyApplication extends Application {
    private String cookie = null;
    private String userId = null;
    private String userName = null;
    private String school = null;
    private String sex = null;

    public void setCookie(String sessionId){
        this.cookie = sessionId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setSchool(String school){
        this.school = school;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getUserId(){
        return userId;
    }

    public String getUserName(){
        return userName;
    }

    public String getSchool(){
        return school;
    }

    public String getSessionId(){
        return cookie;
    }

    public String getSex(){
        return sex;
    }

    public void clear(){
        userId = null;
        userName = null;
        cookie = null;
        school = null;
        sex = null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }
}
