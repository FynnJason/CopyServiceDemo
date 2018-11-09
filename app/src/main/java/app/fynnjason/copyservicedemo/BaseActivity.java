package app.fynnjason.copyservicedemo;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

/**
 * Author：FynnJason
 * Describe：
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    abstract Activity getActivity();

    @Override
    protected void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(MainActivity.COPY_TEXT)) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("您要搜索以下商品吗？")
                    .setMessage(MainActivity.COPY_TEXT)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getActivity(),Main3Activity.class);
                            intent.putExtra("copy",MainActivity.COPY_TEXT);
                            getActivity().startActivity(intent);
                            MainActivity.COPY_TEXT = null;
                            dialogInterface.cancel();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.COPY_TEXT = null;
                            dialogInterface.cancel();
                        }
                    })
                    .create()
                    .show();
        }
    }
}
