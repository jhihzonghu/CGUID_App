package cc.jhz.cgup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

/**
 * Created by jhihzonghu on 2015/5/4.
 */
public class AdoptionInfoDialogFrament extends DialogFragment {
    private int index ;
    private TextView textView,textView1,textView2;
    public AdoptionInfoDialogFrament(){};
    private Typeface typeface;
    private View view ;
    public static AdoptionInfoDialogFrament newInstance(int AnimalNO)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("AnimalNO", AnimalNO);
        AdoptionInfoDialogFrament adoptionInfoDialogFrament = new AdoptionInfoDialogFrament();
        adoptionInfoDialogFrament.setArguments(bundle);
        return  adoptionInfoDialogFrament;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.dialogfragmentcontent,null);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/corbel.ttf");
        textView = (TextView)view.findViewById(R.id.dialog_AdopDateTxt);
        textView2 = (TextView)view.findViewById(R.id.dialog_BearNameTxt);
        textView1 = (TextView)view.findViewById(R.id.Dialog_Parentnametxt);
        textView.setTypeface(typeface);
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        initWidget();

        builder.setTitle("Adoption Info")
                .setView(view)
                .setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor editor= getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                        editor.putString("AnimalNO", ""+index);
                        editor.commit();
                        StartAnimation();

                    }
                })
                .setNegativeButton("BACK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().dismiss();
                    }
                });
        return builder.create();
    }
    private void StartAnimation() {
        SharedPreferences preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String animal =  preferences.getString("AnimalNO", "");
        int Position2 = Integer.valueOf(animal);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new AnimalAnimation().newInstance(Position2)).commit();


    }
    private void initWidget()
    {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments().getInt("AnimalNO") ;

    }
}
