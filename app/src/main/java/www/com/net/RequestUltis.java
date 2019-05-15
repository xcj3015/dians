package www.com.net;


import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Name:  The.xue
 * Date  2019-05-14
 */
public class RequestUltis {

    public static void get(String url, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).method("GET",null).build();
        client.newCall(request).enqueue(callback);
    }

}
