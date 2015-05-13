package cc.jhz.cgup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by jhihzonghu on 2015/5/4.
 */
public class AdoptionInfoDialogFrament extends DialogFragment {
    private int index ;
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
                        SharedPreferences.Editor editor= getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                        editor.putString("AnimalNO", "" + index);
                        editor.commit();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new AnimalAnimation().newInstance(index)).commit();
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments().getInt("AnimalNO") ;
    }
}
