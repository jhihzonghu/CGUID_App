package cc.jhz.cgup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.WindowManager;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Home on 2015/4/18.
 */
public class AnimalAnimation extends FragmentActivity {
    private GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amination);
        initWidget();
        setGifImgRes();
    }
    private void  initWidget()
    {
        gifImageView = (GifImageView)findViewById(R.id.animationImg);
    }
    private void setGifImgRes()
    {
        gifImageView.setImageResource(R.drawable.polorgif);
    }

}
