package www.com;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.google.gson.Gson;
import java.util.List;
import www.com.adapter.MyPageAdapter;
import www.com.bean.XbnnerBean;
import www.com.mvp.PresenterIml;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private PresenterIml presenterIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        presenterIml = new PresenterIml(this);
        presenterIml.xbanner();
    }

    public void doXbnner(String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                XbnnerBean xbnnerBean = gson.fromJson(data, XbnnerBean.class);
                List<XbnnerBean.ResultBean> result = xbnnerBean.getResult();

                MyPageAdapter adapter = new MyPageAdapter(MainActivity.this,result);
                recycler.setAdapter(adapter);
            }
        });
    }
}
