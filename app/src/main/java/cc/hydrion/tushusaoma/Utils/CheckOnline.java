package cc.hydrion.tushusaoma.Utils;

import android.content.Context;
import android.telecom.Call;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import cc.hydrion.tushusaoma.R;

public class CheckOnline {

    String url;
    String cookie;
    CallBack mCallBack;

    public interface CallBack{
        void onResult(int code);
    }

    public CheckOnline(Context context,CallBack callBack){
        cookie = context.getSharedPreferences("user",Context.MODE_PRIVATE)
                .getString("cookie","");
        url = context.getResources().getString(R.string.url_login2);
        mCallBack = callBack;
    }

    public  void check(){
        new CheckTask().execute();
    }

     class CheckTask extends MyHttpTask{

        @Override
        protected String getUrl() {
            return url;
        }

        @Override
        protected String getCookie() {
            return cookie;
        }

        @Override
        protected Map<String, String> getParam() {
            return null;
        }

        @Override
         protected void onPostExecute(String result){
            try {
                JSONObject jsonObject = new JSONObject(result);
                mCallBack.onResult(jsonObject.getInt("code"));
            } catch (JSONException e) {
                e.printStackTrace();
                mCallBack.onResult(0);
            }
        }
    }
}
