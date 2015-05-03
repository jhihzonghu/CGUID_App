package cc.jhz.cgup;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Home on 2015/4/18.
 */
public class IntroAnimals extends FragmentActivity{

    FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        /*建立一個沒有title bar的頁面
        * this page is introduce
        * */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introanimals);
        ScrollText();
        TextView textView = (TextView)findViewById(R.id.Introanimal_txt);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        Bundle bundle = this.getIntent().getExtras();
        int c = bundle.getInt("AnimalNO");
        Toast.makeText(this,"AnimalNO"+ c,Toast.LENGTH_SHORT).show();
        Button GoToAnimalAmination = (Button)findViewById(R.id.GoToAnimalsAnimation);
        GoToAnimalAmination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pre_DialogFrament pre_dialogFrament = new Pre_DialogFrament();
                pre_dialogFrament.show(fragmentManager,"Dialog frament");
            }
        });

    }
    public void ScrollText(){

    }
}
