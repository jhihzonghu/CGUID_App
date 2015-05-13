package cc.jhz.cgup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.app.Dialog;
import android.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by jhihzonghu on 2015/5/3.
 */
public class Pre_DialogFrament extends DialogFragment {
    private int AnimalNO;
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
        return new AlertDialog.Builder(getActivity())
                .setTitle("*n"+"\n"+"Thank You")
                .setMessage("Thanks for your kindness for adopting me." + "\n" + "Now,you have the responsibility to take care of me,my friend" +
                        "\n\n"+"Let your phone rest for 200 hours, I will be super healthy at the same time")
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
}
