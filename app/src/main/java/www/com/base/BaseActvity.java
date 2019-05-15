package www.com.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Name:  The.xue
 * Date  2019-05-14
 */
public abstract class BaseActvity extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        bindView();
        initData();
    }

    protected abstract void bindView();

    protected abstract void initData();

    protected abstract int initLayout();
}
