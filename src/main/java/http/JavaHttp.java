package http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class JavaHttp {
    private URL url;
    private String serverUrl="http://172.30.123.240:8087/rgci/outside/sys/findComProjectInfoWithBaseLineAndDeb";;
    private String data="[{\"calculateWay\":\"1\",\"id\":1,\"project\":\"12.RPL1\"},{\"calculateWay\":\"2\",\"id\":2,\"project\":\"12.5PL4\"}]\"";
    public JavaHttp(){
        try {
            url=new URL(serverUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public boolean post(){
        try {
            URLConnection connection=this.url.openConnection();
            Map a= (Map)JSON.parseObject(data);
            for (Object key:a.entrySet()) {
                connection.setRequestProperty((String)key , (String)((Map.Entry)key).getValue());
            }
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
