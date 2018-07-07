package cc.hydrion.tushusaoma.Bean;

import android.media.MediaCas;

/**
 * Created by Hydrion on 2018/3/1.
 */

public class UserInfo {
    private String sessionId = null;
    private String userId = null;
    private String userName = null;
    private String school = null;
    private String sex = null;

    public void setSessionId(String sessionId){
        this.sessionId = sessionId;
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
        return sessionId;
    }

    public String getSex(){
        return sex;
    }

    public void clear(){
        userId = null;
        userName = null;
        sessionId = null;
        school = null;
        sex = null;
    }
}
