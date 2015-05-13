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

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by jhihzonghu on 2015/3/10.
 */
public class StatusFragment extends Fragment {
    private int index ;
    private GifImageView gifImageView ;
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
        index = getArguments().getInt("AnimalNO");
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
           position = getArguments().getInt("AnimalNO");
           View rootview = inflater.inflate(R.layout.amination,container,false);
           gifImageView = (GifImageView)rootview.findViewById(R.id.animationImg);
        return rootview;
    }
}
