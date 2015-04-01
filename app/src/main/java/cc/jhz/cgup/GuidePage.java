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
    int GuidePosition=0;
    int FunctionMAX = 4;

    //FragmentManager fragmentManager ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidepage);
        Button skipButton = (Button)findViewById(R.id.skipButton);
        Button nextButton = (Button)findViewById(R.id.nextButton);
        GuideIndex = this.getIntent().getExtras();
        GuidePosition = GuideIndex.getInt("BundleToGuidePageVal");
        GuidePageContentFragment guidePageContentFragment = new GuidePageContentFragment() ;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.LayoutForFragment, new GuidePageContentFragment().newInstance(GuidePosition)).commit();

        initGuideIndex(nextButton);
    }
    public void initGuideIndex(Button nextButton)
    {

    }
}
