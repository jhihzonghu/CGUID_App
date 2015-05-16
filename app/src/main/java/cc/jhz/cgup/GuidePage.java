package cc.jhz.cgup;


        import android.app.Activity;
        import android.app.Fragment;
        import android.os.Bundle;
        //import android.app.FragmentActivity;
        import android.app.FragmentManager;
        import android.app.FragmentTransaction;
        import android.app.Fragment;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

/**
 * Created by Home on 2015/3/21.
 */

public class GuidePage extends Activity {
    Bundle GuideIndex ;
    int GuidePosition=0,i=0;
    int FunctionMAX = 3;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    //FragmentManager fragmentManager ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidepage);
        Button skipButton = (Button)findViewById(R.id.skipButton);
        Button nextButton = (Button)findViewById(R.id.nextButton);

        GuideIndex = this.getIntent().getExtras();
        GuidePosition = GuideIndex.getInt("BundleToGuidePageVal");

        //Time:20150402  Guide Page function 50%
        //備註：需要再需要使用fragment的地方直接呼叫FragmentManager以及FragmentTransaction，不然會有空指針的問題
        //fragment與Activiy傳值有兩種方式，第一種再Fragment構造一個方法，再Activity呼叫Fragment的時候將變數數值
        //傳遞過去。
        //第二種方法是使用Bundle再，呼叫方法的位置是在Fragment。也就是再Fragment處理bundle值。
        GuidePageContentFragment guidePageContentFragment = new GuidePageContentFragment().newInstance(GuidePosition) ;
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.LayoutForFragment, guidePageContentFragment).commit();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                Toast.makeText(getBaseContext(),""+i+1,Toast.LENGTH_SHORT).show();
                FragmentManager  fragmentManager1 =getFragmentManager() ;
                GuidePageContentFragment guidePageContentFragment1 = init(i);
                FragmentTransaction fragmentTransaction =fragmentManager1.beginTransaction();
                if(!fragmentTransaction.isEmpty())
                {
                    fragmentTransaction.remove(guidePageContentFragment1);
                    fragmentTransaction.add(R.id.LayoutForFragment, guidePageContentFragment1);

                }
                else
                {
                    fragmentTransaction.add(R.id.LayoutForFragment, guidePageContentFragment1);
                }
                fragmentTransaction.commit();
            }

        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public GuidePageContentFragment init(int index)
    {
        return new GuidePageContentFragment().newInstance(index);
    }
}
