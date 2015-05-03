package cc.jhz.cgup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.app.Dialog;
import android.app.AlertDialog;
/**
 * Created by jhihzonghu on 2015/5/3.
 */
public class Pre_DialogFrament extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("*n"+"\n"+"Thank You")
                .setMessage("Thanks for your kindness for adopting me." + "\n" + "Now,you have the responsibility to take care of me,my friend" +
                        "\n\n"+"Let your phone rest for 200 hours, I will be super healthy at the same time")
                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

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
