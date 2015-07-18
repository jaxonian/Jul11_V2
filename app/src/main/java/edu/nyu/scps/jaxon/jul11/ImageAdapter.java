package edu.nyu.scps.jaxon.jul11;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by jaxonian on 7/16/15.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;

    private int[] sample = {
            R.drawable.joey_l_0,
            R.drawable.abdoulaye_l_1,
            R.drawable.asa_l_2,
            R.drawable.keenen_l_3,
            R.drawable.mark_l_4,
            R.drawable.alrick_l_5,
            R.drawable.david_l_6,
            R.drawable.deepali_l_7,
            R.drawable.jaxon_l_8,
            R.drawable.jeffrey_l_9
    };

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        Resources resources = context.getResources();
        Drawable drawable = resources.getDrawable(sample[position % sample.length]);
        return drawable;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            //Convert 60 dp to pixels.
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int pixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, displayMetrics);

            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(pixels, pixels));
            imageView.setAdjustViewBounds(false);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int padding = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, displayMetrics);
            imageView.setPadding(padding, padding, padding, padding);
        } else {
            imageView = (ImageView)convertView;
        }

        imageView.setImageResource(sample[position % sample.length]);
        return imageView;
    }
}
