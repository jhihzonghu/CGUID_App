package cc.jhz.cgup;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;

import org.w3c.dom.Text;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Home on 2015/4/18.
 */
public class IntroAnimals extends Fragment {
    private Button GoToAnimalAmination;
    private int GuidPageNumber = 6 ;
    private FrameLayout frameLayout ;
    private TextView textView;
    private ImageView imageview ;
    private int[] IntroTxt ={
            R.drawable.phonimalsstatus_01,R.drawable.phonimalsstatus_02,
            R.drawable.phonimalsstatus_03,R.drawable.phonimalsstatus_04
    };
    private String[] IntroAnimalTxt =
            {"THREADS\n" +
                    "The loss of sea ice habitat from climate " +
                    "change is the biggest threat to the sur-" +
                    "vival of polar bears. Other key threats " +
                    "include polar bear-human conflicts, " +
                    "overharvesting and industrial impacts.",
            "THREADS\n" +
                    "The scarcity of prey is the most preva-" +
                    "lent threat for the Arctic fox. Disease " +
                    "and genetic pollution of the species by " +
                    "foxes bred in captivity also threatens " +
                    "this species.",
            "THREADS\n" +
                    "Vessels that support oil and gas develop-" +
                    "ment mean increased shipping in sensi-" +
                    "tive areas. Increased shipping means " +
                    "more noise that can mask communica-" +
                    "tions for many Arctic marine species and" +
                    "it increases the potential for collisions " +
                    "with marine mammals, especially " +
                    "whales. It also brings more pollution and " +
                    "a greater possibility of oil or fuel spills.",
            "THREADS\n" +
                    "The retreat of sea ice caused by climate " +
                    "change forces walruses ashore, with " +
                    "deadly consequences As arctic sea ice " +
                    "recedes far from the Russian and Alas-" +
                    "kan coasts due to warmer temperatures, " +
                    "walruses – including females and their " +
                    "babies – are forced to take refuge on " +
                    "land."
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
        frameLayout =(FrameLayout)getActivity().findViewById(R.id.container);
        frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.mainpage_bkground));

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
        textView.setText(IntroAnimalTxt[index]);

    }
    private void initWidget(View rootview) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Arial.ttf");
        Typeface typeface1 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/corbel.ttf");
        GoToAnimalAmination = (Button) rootview.findViewById(R.id.GoToAnimalsAnimation);
        GoToAnimalAmination.setTypeface(typeface);
        textView = (TextView) rootview.findViewById(R.id.Introanimal_txt);
        textView.setTypeface(typeface1);

        imageview = (ImageView)rootview.findViewById(R.id.IntroanimalTxtView);
        gifImageView =(GifImageView)rootview.findViewById(R.id.introanimalsImg);
    }

    private void setScrollTxtView() {

        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ((MainPage)getActivity()).setActionbarTxt(((MainPage)getActivity()).getmTitle());
        frameLayout =(FrameLayout)getActivity().findViewById(R.id.container);
        frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.mainpage_bkground));
    }
}
