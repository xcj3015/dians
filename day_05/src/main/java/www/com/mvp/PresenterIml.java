package www.com.mvp;

import www.com.MainActivity;
import www.com.api.Api;

/**
 * Name:  The.xue
 * Date  2019-05-15
 */
public class PresenterIml implements Presenter{

    private ModelIml modelIml;
    MainActivity mainActivity;
    public PresenterIml(MainActivity mainActivity){
        modelIml = new ModelIml();
        this.mainActivity = mainActivity;
    }

    @Override
    public void xbanner() {
        modelIml.Xbanner(Api.Xbanner_url, new Model.Callback() {
            @Override
            public void success(String data) {
                mainActivity.doXbnner(data);
            }
        });
    }
}
