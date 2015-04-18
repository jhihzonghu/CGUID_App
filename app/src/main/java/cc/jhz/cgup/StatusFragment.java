package cc.jhz.cgup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.zip.GZIPOutputStream;

/**
 * Created by jhihzonghu on 2015/3/10.
 */
public class StatusFragment extends Fragment {
    public StatusFragment(){}
    public static StatusFragment newInstance(int index)
    {
        StatusFragment statusFragment = new StatusFragment();
        Bundle Position = new Bundle();
        Position.putInt("AnimalNO",index);
        statusFragment.setArguments(Position);
        return statusFragment;
    }
    int position;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
           position = getArguments().getInt("AnimalNO");
           Toast.makeText(getActivity(),"This animals is "+position,Toast.LENGTH_LONG).show();
           View rootview = inflater.inflate(R.layout.introanimals,container,false);
           Button gotoanimalanimationButton = (Button)rootview.findViewById(R.id.GoToAnimalsAnimation);
            gotoanimalanimationButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Bundle GotoAnimalAminationClass = new Bundle();
                   GotoAnimalAminationClass.putInt("AnimalAminatonNO",position);
                   Intent GotoAnimalAmination = new Intent(getActivity().getBaseContext(),AnimalAnimation.class);
                   GotoAnimalAmination.putExtras(GotoAnimalAmination);
               }
           });
        return rootview;
    }
}
