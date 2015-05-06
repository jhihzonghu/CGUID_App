package cc.jhz.cgup.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import cc.jhz.cgup.AnimalAnimation;
import cc.jhz.cgup.AnimationContainer;
import cc.jhz.cgup.MainPage;
import cc.jhz.cgup.R;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by jhihzonghu on 2015/5/4.
 */
public class ScreenMonitor extends BroadcastReceiver {

    private Bundle bundle;

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences preferences = context.getSharedPreferences("data", context.MODE_PRIVATE);
        String animal = preferences.getString("AnimalNO", "");
        if (animal.equals(null)) {
            Intent intentbackMain = new Intent(context, MainPage.class);
            Toast.makeText(context, "No Adoption Any Animal", Toast.LENGTH_SHORT).show();
            context.startActivity(intentbackMain);
        } else {
            //bundle.putInt("AnimalNO", Integer.valueOf(animal));
            Intent Container = new Intent(context, AnimationContainer.class);
            Container.putExtras(bundle);
            Container.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(Container);
        }
    }
}

