package cc.jhz.cgup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;

/**
 * Created by jhihzonghu on 2015/3/10.
 */
public class CustomerbaseadAdapter extends BaseAdapter {
    Context context;
    int[] Item;

    public CustomerbaseadAdapter(Context context, int[] Item) {
        this.Item = Item;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Item.length;
    }

    @Override
    public Object getItem(int position) {
        return Item[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgview= null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(FragmentActivity.LAYOUT_INFLATER_SERVICE);
        View rootview ;
        rootview = mInflater.inflate(R.layout.customlistview, null);
        imgview = (ImageView) rootview.findViewById(R.id.customimgview);
        Bitmap bitmap = readBitmap(context,Item[position]);
        imgview.setImageBitmap(bitmap);
        return rootview;
    }
    //20150408 new Function resolve OOM Err (CustomerBasedAdapter->ReadBitMap())
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
