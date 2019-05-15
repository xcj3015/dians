package www.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Name:  The.xue
 * Date  2019-05-15
 */
public class Activity extends AppCompatActivity {
    private static final String TAG = "薛超杰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Log.d(TAG, "The activity state---->onCreate");
    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "The activity state---->onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "The activity state---->onRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "The activity state---->onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "The activity state---->onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "The activity state---->onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "The activity state---->onDestroy");
    }
}
