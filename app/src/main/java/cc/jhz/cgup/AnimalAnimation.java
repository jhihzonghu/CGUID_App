package cc.jhz.cgup;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Home on 2015/4/18.
 */
public class AnimalAnimation extends Fragment {

    int position ;
    private GifImageView gifImageView;
    private int[]  GifImgRes = {
            R.drawable.polar_walk2,R.drawable.fox_walk,
            R.drawable.beluga, R.drawable.walrus,
    };
    public AnimalAnimation(){}
    public static AnimalAnimation newInstance(int index)
    {
        AnimalAnimation animalAnimation = new AnimalAnimation();
        Bundle bundle = new Bundle();
        bundle.putInt("Index", index);
        animalAnimation.setArguments(bundle);
        return  animalAnimation;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("Index");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.amination, container, false);
        gifImageView = (GifImageView)rootview.findViewById(R.id.animationImg);
        gifImageView.setImageResource(GifImgRes[position]);
        return rootview;

    }
}
