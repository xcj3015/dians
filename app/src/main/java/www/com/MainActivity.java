package www.com;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import www.com.adapter.MyAdapter;
import www.com.base.BaseActvity;
import www.com.bean.ShowBean;
import www.com.bean.XBannerBean;
import www.com.mvp.Contract;
import www.com.mvp.PresenterIml;

public class MainActivity extends BaseActvity {

    private RecyclerView recycler;
    private Contract.IPresenter presenterIml;
    private XBannerBean xbannerbean;


    @Override
    protected void bindView() {
        recycler = findViewById(R.id.recycle);

        LinearLayoutManager lin = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(lin);
        presenterIml = new PresenterIml(this);
    }

    @Override
    protected void initData() {
        presenterIml.doList();
        presenterIml.xbanner();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    public void getviewXbanner(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                xbannerbean  = gson.fromJson(data, XBannerBean.class);
                // MyAdapter myAdapter =new MyAdapter(getActivity(), xbannerBean);
                // recycle.setAdapter(myAdapter);
            }
        });
    }
    
    public void doList(String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                ShowBean muckBean = gson.fromJson(data, ShowBean.class);
                ShowBean.ResultBean result = muckBean.getResult();

                MyAdapter adapter = new MyAdapter(MainActivity.this, result,xbannerbean);
                recycler.setAdapter(adapter);
            }
        });
    }
}
