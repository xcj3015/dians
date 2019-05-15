package www.com.mvp;

/**
 * Name:  The.xue
 * Date  2019-05-14
 */
public interface Contract {

    public interface IView{
        void success(String data);
    }

    public interface IModel{

        void ShowList(String url,Callback callback);
        void Xbanner(String url,Callback callback);
    }

    public interface IPresenter{
        void doList();
        void xbanner();
    }

    public interface Callback{
        void success(String data);
    }

}
