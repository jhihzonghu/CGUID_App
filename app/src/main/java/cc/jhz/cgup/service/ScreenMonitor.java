package cc.jhz.cgup.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import cc.jhz.cgup.AnimalAnimation;
import cc.jhz.cgup.AnimationContainer;

/**
 * Created by jhihzonghu on 2015/5/4.
 */
public class ScreenMonitor extends BroadcastReceiver {
    private int AnimalNo ;
    private Bundle bundle ;
    private Intent Container ;
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals((Intent.ACTION_SCREEN_ON)))
        {

            Intent Container = new Intent(context, AnimationContainer.class);
            Container.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(Container);
        }
    }

}
