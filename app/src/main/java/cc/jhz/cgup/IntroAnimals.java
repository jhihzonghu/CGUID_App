package cc.jhz.cgup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.MissingFormatArgumentException;

import cc.jhz.cgup.service.ScreenService;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Home on 2015/4/18.
 */
public class IntroAnimals extends Fragment {
    private Button GoToAnimalAmination;
    private int GuidPageNumber = 6 ;
    private TextView textView;
    private ImageView imageview ;
    private int[] IntroTxt ={
            R.drawable.phonimalsstatus_01,R.drawable.phonimalsstatus_02,
            R.drawable.phonimalsstatus_03,R.drawable.phonimalsstatus_04
    };
    private GifImageView gifImageView ;
    private int[] GifRes =
            {
              R.drawable.polaradopt,R.drawable.foxadopt,
              R.drawable.belugaadopt,R.drawable.walrusadopt
            };
    public IntroAnimals (){}
    int index ;
    public static IntroAnimals newInstance(int index)
    {
        IntroAnimals introAnimals = new IntroAnimals();
        Bundle bundle = new Bundle();
        bundle.putInt("AnimalNO", index);
        introAnimals.setArguments(bundle);
        return introAnimals;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.introanimals, container, false);

        Toast.makeText(getActivity().getApplicationContext(),""+GuidPageNumber,Toast.LENGTH_SHORT).show();
        initWidget(rootView);
        setWidgetValue(index);
        setScrollTxtView();
        AdoptionProcess();
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments().getInt("AnimalNO");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_page,menu);

    }


    private void AdoptionProcess() {

        GoToAnimalAmination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pre_DialogFrament pre_dialogFrament = new Pre_DialogFrament().newInstance(index);
                pre_dialogFrament.show(getActivity().getSupportFragmentManager(), "dlg");
            }
        });
    }
    private void setWidgetValue(int index)
    {
       gifImageView.setImageResource(GifRes[index]);
       imageview.setImageResource(IntroTxt[index]);

    }
    private void initWidget(View rootview) {
        GoToAnimalAmination = (Button) rootview.findViewById(R.id.GoToAnimalsAnimation);
        textView = (TextView) rootview.findViewById(R.id.Introanimal_txt);
        imageview = (ImageView)rootview.findViewById(R.id.IntroanimalTxtView);
        gifImageView =(GifImageView)rootview.findViewById(R.id.introanimalsImg);
    }

    private void setScrollTxtView() {

        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }







}
