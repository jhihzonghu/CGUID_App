package cc.jhz.cgup;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Home on 2015/3/21.
 */

public class GuidePage extends FragmentActivity {
    Bundle GuideIndex ;
    int GuidePosition=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.guidepage);
        Button skipButton = (Button)findViewById(R.id.skipButton);
        Button nextButton = (Button)findViewById(R.id.nextButton);
        initGuideIndex();
    }
    public void initGuideIndex()
    {
     GuideIndex = this.getIntent().getExtras();
     GuidePosition = GuideIndex.getInt("BundleToGuidePageVal");
     Toast.makeText(this,""+GuidePosition,Toast.LENGTH_SHORT).show();
    }
}
