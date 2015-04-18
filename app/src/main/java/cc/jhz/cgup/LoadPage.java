package cc.jhz.cgup;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import java.lang.Thread;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jhihzonghu on 2015/3/9.
 */
public class LoadPage extends Activity   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.loadpage);
        final Intent welcomeToMain= new Intent(this,MainPage.class);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
               startActivity(welcomeToMain);
            }
        };
        timer.schedule(timerTask,1500);

    }

    /*
    * 2015/4/19
    * 1. debug : this activity will finish after it go to MainPage
    *
    * */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}

