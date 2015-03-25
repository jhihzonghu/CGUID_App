package cc.jhz.cgup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Home on 2015/3/21.
 */
public class GuidePageContentFragment extends Fragment {
  public GuidePageContentFragment(){}
  public static GuidePageContentFragment newInstance(int index)
  {
    GuidePageContentFragment guidePageContentFragment = new GuidePageContentFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("index",index);
    guidePageContentFragment.setArguments(bundle);
    return guidePageContentFragment;
  }
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View GuidPageContentView = inflater.inflate(R.layout.contentfragment,container,false);
        return GuidPageContentView;
    }
}
