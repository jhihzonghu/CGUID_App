package cc.jhz.cgup.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;

import cc.jhz.cgup.R;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by jhihzonghu on 2015/5/6.
 */
public class ScreenService2 extends Service {
    private WindowManager windowManager;
    private GifImageView chatHead;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        chatHead = new GifImageView(this);
        chatHead.setImageResource(R.drawable.polorgif);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        //params.gravity = Gravity.TOP | Gravity.LEFT;
       // params.x = 0;
        //params.y = 100;

        windowManager.addView(chatHead, params);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (chatHead != null) windowManager.removeView(chatHead);
    }
}
