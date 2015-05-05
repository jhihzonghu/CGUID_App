package cc.jhz.cgup;

import android.app.Activity;
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
    private int AnimalNO;
    private Intent GoToGifContainer, KeepServiceOn;
    private MainPage mainPage = new MainPage();


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introanimals);
        GoToGifContainer = this.getIntent();
        AnimalNO =GoToGifContainer.getExtras().getInt("AnimalNO");
        GoToGifContainer.putExtra("AnimalNO", AnimalNO);
        initWidget();
        setScrollTxtView();
        setExtraValue();

       // Toast.makeText(this, "AnimalNO" + AnimalNo, Toast.LENGTH_SHORT).show();
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


                pre_dialogFrament.show(getSupportFragmentManager(), "dlg");
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

    public void setExtraValue()
    {
        this.AnimalNO = this.getIntent().getExtras().getInt("AnimalNO");
    }
    public int getExtraValue() {

        return this.AnimalNO;
    }

    public void LKScreenisOK() {

      // Toast.makeText(this, "IntroAnimals"+AnimalNO, Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, "onRestart"+AnimalNO, Toast.LENGTH_SHORT).show();
       // setResult(Activity.RESULT_OK, GoToGifContainer);
        Bundle bundle = new Bundle();
        bundle.putInt("AnimalNO",getExtraValue());
        KeepServiceOn = new Intent(this,AnimationContainer.class);
        KeepServiceOn.putExtras(bundle);
        startActivity(KeepServiceOn);
        //startActivity(GoToGifContainer);

    }


    public boolean getLKScreenON() {
        return this.LKScreenON;
    }

}