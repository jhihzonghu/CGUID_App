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
  int[] DrawableSrc = {R.drawable.btnmenu1,R.drawable.btnmenu2,R.drawable.btnmenu3,R.drawable.btnmenu4,R.drawable.btnmenu5};
  static String Index ="index";
  static  int GlobalNum =0 ;
 public GuidePageContentFragment()
 {

 }
   //20150402 完成Activity與Fragment參數傳遞
   //新增GuidePageContentFragment中 newInstance的方法
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
    //20150402 可以定位目前使用者所在page
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View GuidPageContentView = inflater.inflate(R.layout.contentfragment,container,false);
        ImageView imageView = (ImageView)GuidPageContentView.findViewById(R.id.contentFragmentImg);
        int Position = getArguments().getInt(Index);
        imageView.setImageResource(DrawableSrc[Position]);

        return GuidPageContentView;
    }

}
