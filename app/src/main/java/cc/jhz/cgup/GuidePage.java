package cc.jhz.cgup;


        import android.app.Activity;
        import android.app.Fragment;
        import android.graphics.Typeface;
        import android.os.Bundle;
        //import android.app.FragmentActivity;
        import android.app.FragmentManager;
        import android.app.FragmentTransaction;
        import android.app.Fragment;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;

/**
 * Created by Home on 2015/3/21.
 */

public class GuidePage extends Activity {
    Bundle GuideIndex ;
    int GuidePosition=0,i=0;
    int FunctionMAX = 3;
    private TextView textView ;
    private Typeface typeface, typeface2;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private String[] GuideContent= {"Step 1 : Click the animal you like.",
            "Step 2 : After realizing each animal’s status and threads,you can decide to adopt or not.",
            "Step 3 : Give your animal a name and you can keep it after that.",
            "Step 4 : you can check your animal through your live wallpaper." ,
            };
    //FragmentManager fragmentManager ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidepage);
        Button skipButton = (Button)findViewById(R.id.skipButton);
        Button nextButton = (Button)findViewById(R.id.nextButton);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/corbel.ttf");
        typeface2 = Typeface.createFromAsset(getAssets(),"fonts/Arial.ttf");
        textView = (TextView)findViewById(R.id.guidpageTxt);
        GuideIndex = this.getIntent().getExtras();
        GuidePosition = GuideIndex.getInt("BundleToGuidePageVal");
        textView.setTypeface(typeface);
        skipButton.setTypeface(typeface2);
        nextButton.setTypeface(typeface2);
        textView.setText(GuideContent[GuidePosition]);
        //Time:20150402  Guide Page function 50%
        //備註：需要再需要使用fragment的地方直接呼叫FragmentManager以及FragmentTransaction，不然會有空指針的問題
        //fragment與Activiy傳值有兩種方式，第一種再Fragment構造一個方法，再Activity呼叫Fragment的時候將變數數值
        //傳遞過去。
        //第二種方法是使用Bundle再，呼叫方法的位置是在Fragment。也就是再Fragment處理bundle值。
        GuidePageContentFragment guidePageContentFragment = new GuidePageContentFragment().newInstance(0) ;
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
                    textView.setTypeface(typeface);
                    textView.setText(GuideContent[i]);
                }
                else
                {
                    if(i<=FunctionMAX) {
                        fragmentTransaction.add(R.id.LayoutForFragment, guidePageContentFragment1);
                        textView.setTypeface(typeface);
                        textView.setText(GuideContent[i]);
                    }else{
                        GuidePageContentFragment guidePageContentFragment2 = init(0);
                        fragmentTransaction.remove(guidePageContentFragment1);
                        textView.setTypeface(typeface);
                        textView.setText(GuideContent[0]);
                        fragmentTransaction.add(R.id.LayoutForFragment, guidePageContentFragment1);
                    }
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
