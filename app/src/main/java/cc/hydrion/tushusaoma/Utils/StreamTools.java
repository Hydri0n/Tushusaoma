package cc.hydrion.tushusaoma.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by LiFen on 2017/10/22.
 */

public class StreamTools {
    //把一个inputStream 转换成 String

    public static String readStream(InputStream in) throws IOException {

        //定义一个内存输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte[] buffer = new byte[1024];
        while((len= in.read(buffer)) != -1){
            baos.write(buffer,0,len);
        }
        in.close();
        String content = new String(baos.toByteArray());
        return content;
    }
}
