package cc.jhz.cgup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by jhihzonghu on 2015/5/4.
 */
public class AdoptionInfoDialogFrament extends DialogFragment {
    private IntroAnimals introAnimals = new IntroAnimals();
    private Boolean ISScreenOn = true;
    private Context context;
    public AdoptionInfoDialogFrament(){};
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
        View view = inflater.inflate(R.layout.dialogfragmentcontent,null);

        builder.setTitle("Adoption Info")
                .setView(view)
                .setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((IntroAnimals)getActivity()).LKScreenisOK();



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



    private void setON(boolean isScreen)
    {
        this.ISScreenOn = isScreen ;
    }
    private boolean getON()
    {
        return this.ISScreenOn;
    }


}
