package cc.hydrion.tushusaoma.Utils;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import cc.hydrion.tushusaoma.R;


public abstract class MyHttpTask extends AsyncTask<Integer,Integer,String> {

    private String strUrl;
    private String cookie;
    private Map<String,String> param;

    public MyHttpTask(){
        super();
        strUrl = getUrl();
        if (getCookie() != null )
            cookie = getCookie();
        else cookie = "";
        param = getParam();
    }

    protected abstract String getUrl();

    protected abstract String getCookie();

    protected abstract Map<String,String> getParam();

    @Override
    protected String doInBackground(Integer... integers) {
        String result = null;
        try {
            if (param != null){
                strUrl = strUrl + "?";
                Iterator<Map.Entry<String,String>> entries = param.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry<String,String> entry = entries.next();
                    strUrl = strUrl + entry.getKey() + "="
                            + URLEncoder.encode(entry.getValue(),"utf-8")
                            + "&";
                }
            }
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.addRequestProperty("Cookie",cookie);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = reader.readLine())!= null){
                sb.append(str);
            }
            result = sb.toString();
            //JSONObject jsonObject = new JSONObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
