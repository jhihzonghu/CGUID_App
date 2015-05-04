package cc.jhz.cgup.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * Created by jhihzonghu on 2015/5/4.
 */
public class ScreenService extends Service {
    BroadcastReceiver broadcastReceiver;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        broadcastReceiver = new ScreenMonitor();
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
