package www.com.mvp;

/**
 * Name:  The.xue
 * Date  2019-05-15
 */
public interface Model {
    void Xbanner(String url,Callback callback);

    public interface Callback{
        void success(String data);
    }
}
