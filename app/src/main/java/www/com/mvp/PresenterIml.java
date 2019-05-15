package www.com.mvp;

import www.com.MainActivity;
import www.com.api.Api;
import www.com.mvp.Contract;
import www.com.mvp.ModelIml;

/**
 * Name:  The.xue
 * Date  2019-05-14
 */
public class PresenterIml implements Contract.IPresenter {
    private Contract.IModel iModel;
    private MainActivity mainActivity;

    public PresenterIml(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        iModel = new ModelIml();
    }

    @Override
    public void doList() {
        iModel.ShowList(Api.Home_url, new Contract.Callback() {
            @Override
            public void success(String data) {
                mainActivity.doList(data);
            }
        });
    }

    @Override
    public void xbanner() {
        iModel.ShowList(Api.Xbanner_url, new Contract.Callback() {
            @Override
            public void success(String data) {
                mainActivity.getviewXbanner(data);
            }
        });
    }
}
