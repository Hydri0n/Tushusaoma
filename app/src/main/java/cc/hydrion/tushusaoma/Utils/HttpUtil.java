package cc.hydrion.tushusaoma.Utils;

import org.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Hydrion on 2018/2/25.
 */

public class HttpUtil {
        public static String post(String url,JSONObject param)
                throws ParseException, IOException, JSONException {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost request = new HttpPost(url);
            StringEntity se = new StringEntity(param.toString());
            request.setEntity(se);
            HttpResponse httpResponse = httpClient.execute(request);
            int code = httpResponse.getStatusLine().getStatusCode();
            System.out.print(code);
            String result = EntityUtils.toString(httpResponse.getEntity());
            JSONObject result1 = new JSONObject(result);
            String info = (String) result1.get("retInfo");
            return info;
        }
}
