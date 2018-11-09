package app.fynnjason.copyservicedemo;

import android.app.Service;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Author：FynnJason
 * Describe：监听剪切板服务
 */
public class CopyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    ClipboardManager clipboardManager;

    @Override
    public void onCreate() {
        super.onCreate();
        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (null != clipboardManager) {
            clipboardManager.addPrimaryClipChangedListener(listener);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        clipboardManager.removePrimaryClipChangedListener(listener);
        clipboardManager = null;
        super.onDestroy();
    }

    private ClipboardManager.OnPrimaryClipChangedListener listener = new ClipboardManager.OnPrimaryClipChangedListener() {
        @Override
        public void onPrimaryClipChanged() {
            if (clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip().getItemCount() > 0) {
//                MainActivity.COPY_TEXT = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
            }
        }
    };
}
