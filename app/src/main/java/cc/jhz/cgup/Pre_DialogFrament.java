package cc.jhz.cgup;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.app.Dialog;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

/**
 * Created by jhihzonghu on 2015/5/3.
 */
public class Pre_DialogFrament extends DialogFragment {
    private View view ;
    private TextView textView ;
    private int AnimalNO;
    private final int Pre_Index = 7 ;
    public Pre_DialogFrament(){};
    public static Pre_DialogFrament newInstance(int AnimalNO)
    {
        Pre_DialogFrament pre_dialogFrament = new Pre_DialogFrament();
        Bundle bundle = new Bundle();
        bundle.putInt("AnimalNO",AnimalNO);
        pre_dialogFrament.setArguments(bundle);
        return  pre_dialogFrament;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimalNO = getArguments().getInt("AnimalNO");
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/corbel.ttf");
        view = layoutInflater.inflate(R.layout.pre_fragment, null);
        textView = (TextView)view.findViewById(R.id.pre_fragemntTxt);
        textView.setTypeface(typeface);
        textView.setText("Thanks for your kindness for adopting me. Now, you have the responsibility to take care of me, my friend. Let your phone rest for 200 hours, I will be super healthy at the same time.");
        return new AlertDialog.Builder(getActivity())
                .setTitle("Thank You")
                .setView(view)
                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdoptionInfoDialogFrament adoptionInfoDialogFrament = new AdoptionInfoDialogFrament().newInstance(AnimalNO);
                        adoptionInfoDialogFrament.show(getActivity().getSupportFragmentManager(), "DialogFragment");
                    }
                })
                .setNegativeButton("BACK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       getDialog().dismiss();
                    }
                }).create();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_example)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("BundleToGuidePageVal",Pre_Index);
            Intent welcomeToMain= new Intent(getActivity(),GuidePage.class);
            welcomeToMain.putExtras(bundle);
            startActivity(welcomeToMain);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
