package cc.jhz.cgup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cc.jhz.cgup.service.ScreenService;

/**
 * Created by Home on 2015/4/18.
 */
public class IntroAnimals extends FragmentActivity {
    private boolean LKScreenON = false;
    private Button GoToAnimalAmination;
    private TextView textView;
    private Bundle bundle;
    private int c;
    private Intent startScreenService;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(startScreenService);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introanimals);

        initWidget();
        setScrollTxtView();
        getExtraValue();

        Toast.makeText(this, "AnimalNO" + c, Toast.LENGTH_SHORT).show();
        if (this.getLKScreenON()) {
            GoToAnimalAmination.setEnabled(false);
        } else {
            GoToAnimalAmination.setEnabled(true);
            AdoptionProcess();
        }


    }

    private void AdoptionProcess() {
        GoToAnimalAmination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pre_DialogFrament pre_dialogFrament = new Pre_DialogFrament();
                pre_dialogFrament.show(fragmentManager, "Dialog frament");
            }
        });
    }

    private void initWidget() {
        GoToAnimalAmination = (Button) findViewById(R.id.GoToAnimalsAnimation);
        textView = (TextView) findViewById(R.id.Introanimal_txt);
    }

    private void setScrollTxtView() {

        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    private void getExtraValue() {
        bundle = this.getIntent().getExtras();
        c = bundle.getInt("AnimalNO");
    }

    public void LKScreenisOK() {

        Toast.makeText(this, "LKScreenIsOK", Toast.LENGTH_SHORT).show();
        startScreenService = new Intent(this,ScreenService.class);
        startService(startScreenService);

    }

    public void setLKScreenON(boolean lkScreenON) {
        this.LKScreenON = lkScreenON;
    }

    public boolean getLKScreenON() {
        return this.LKScreenON;
    }

}
