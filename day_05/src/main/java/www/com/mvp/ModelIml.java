package www.com.mvp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import www.com.net.XbannerUltis;

/**
 * Name:  The.xue
 * Date  2019-05-15
 */
public class ModelIml implements Model {
    @Override
    public void Xbanner(String url, Callback callback) {
        XbannerUltis.get(url, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.success(response.body().string());
            }
        });
    }
}
