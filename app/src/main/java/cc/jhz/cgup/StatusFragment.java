package cc.jhz.cgup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jhihzonghu on 2015/3/10.
 */
public class StatusFragment extends Fragment {
    public StatusFragment(){}
    //public static StatusFragment newInstance(){};
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
           View rootview = inflater.inflate(R.layout.loadpage,container,false);
        return rootview;
    }
}
