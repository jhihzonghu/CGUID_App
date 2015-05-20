package cc.jhz.cgup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

/**
 * Created by Home on 2015/3/21.
 */
public class GuidePageContentFragment extends Fragment {
  int[] DrawableSrc = {
          R.drawable.phonimals_q1,R.drawable.phonimals_q2,
          R.drawable.phonimals_q3,R.drawable.phonimals_q4};
  static String Index ="index";
  static int GlobalNum =0 ;
    int Position;
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
        Position = getArguments().getInt(Index);
        Bitmap bitmap = readBitmap(getActivity().getApplicationContext(),DrawableSrc[Position]);
        imageView.setImageBitmap(bitmap);




        return GuidPageContentView;
    }
    public static Bitmap readBitmap(Context context, int resID)
    {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inPreferredConfig = Bitmap.Config.RGB_565;
        opts.inPurgeable =true ;
        opts.inInputShareable = true;
        InputStream inputStream = context.getResources().openRawResource(resID);
        return BitmapFactory.decodeStream(inputStream,null,opts);
    }

}
