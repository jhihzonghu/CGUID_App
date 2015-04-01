package cc.jhz.cgup;

import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Home on 2015/3/21.
 */
public class GuidePageContentFragment extends Fragment {
  int[] DrawableSrc = {R.drawable.fox,R.drawable.logo,R.drawable.fox,R.drawable.logo,R.drawable.fox};
  static String Index ="index";
  static  int GlobalNum =0 ;
 public GuidePageContentFragment()
 {

 }
  public static GuidePageContentFragment newInstance(int index)
  {
    GuidePageContentFragment guidePageContentFragment = new GuidePageContentFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(Index,index);
    guidePageContentFragment.setArguments(bundle);
    return guidePageContentFragment;
  }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View GuidPageContentView = inflater.inflate(R.layout.contentfragment,container,false);
        ImageView imageView = (ImageView)GuidPageContentView.findViewById(R.id.contentFragmentImg);

        savedInstanceState = getActivity().getIntent().getExtras() ;
        int Position = getArguments().getInt(Index);
        imageView.setImageResource(DrawableSrc[Position]);

        return GuidPageContentView;
    }

}
