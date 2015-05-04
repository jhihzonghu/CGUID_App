package cc.jhz.cgup.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import cc.jhz.cgup.AnimalAnimation;

/**
 * Created by jhihzonghu on 2015/5/4.
 */
public class ScreenMonitor extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals((Intent.ACTION_SCREEN_ON)))
        {
            Intent intent1 = new Intent(context, AnimalAnimation.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    }
}
