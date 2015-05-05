package cc.jhz.cgup;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.WindowManager;
import android.widget.Toast;

import cc.jhz.cgup.service.ScreenService;

/**
 * Created by jhihzonghu on 2015/5/5.
 */
public class AnimationContainer extends FragmentActivity {
    private FragmentManager fragmentManager ;
    private Bundle bundle;
    private int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aminationcontainer);
        fragmentManager = getSupportFragmentManager();
        i=getIntent().getExtras().getInt("AnimalNO");
        Toast.makeText(this, "Animalcontainer:" + i, Toast.LENGTH_SHORT).show();
        fragmentManager.beginTransaction().add(R.id.layoutforGif, new AnimalAnimation().newInstance(i)).commit();
       // Intent intent = new Intent(this,MainPage.class);
      //  intent.putExtra("AnimalNO", i);
      //  startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent keepServie = new Intent(this, ScreenService.class);
        startService(keepServie);
    }
}
