package cc.jhz.cgup;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;

import cc.jhz.cgup.service.ScreenService;

/**
 * Created by jhihzonghu on 2015/5/5.
 */
public class AnimationContainer extends FragmentActivity {
    private FragmentManager fragmentManager ;
    private int i ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aminationcontainer);
        fragmentManager = getSupportFragmentManager();
        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        String animal =  preferences.getString("AnimalNO", "");
        if(animal.equals("")){
            Intent intentbackMain = new Intent(getApplicationContext(), MainPage.class);
            Toast.makeText(getApplicationContext(), "No Adoption Any Animal", Toast.LENGTH_SHORT).show();
            startActivity(intentbackMain);
        }
        else
        {
            final int j = Integer.valueOf(animal);
            Toast.makeText(this, "Animalcontainer:" + j, Toast.LENGTH_SHORT).show();
            fragmentManager.beginTransaction().add(R.id.layoutforGif, new AnimalAnimation().newInstance(j)).commit();
        }
       // Intent intent = new Intent(this,MainPage.class);
      //  intent.putExtra("AnimalNO", i);
      //y  startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(this,MainPage.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
