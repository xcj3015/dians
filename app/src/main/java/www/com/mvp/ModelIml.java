package www.com.mvp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import www.com.api.Api;
import www.com.mvp.Contract;
import www.com.net.RequestUltis;

/**
 * Name:  The.xue
 * Date  2019-05-14
 */
public class ModelIml implements Contract.IModel {

    @Override
    public void ShowList(String url, Contract.Callback callback) {
        RequestUltis.get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.success(response.body().string());
            }
        });
    }

    @Override
    public void Xbanner(String url, Contract.Callback callback) {
        RequestUltis.get(url, new Callback() {
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
