package app.fynnjason.copyservicedemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BaseActivity {

    private Intent intent;
    public static String COPY_TEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(getApplicationContext(), CopyService.class);
        startService(intent);
        startActivity(new Intent(this,Main2Activity.class));
    }

    @Override
    Activity getActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        stopService(intent);
        super.onDestroy();
    }
}
