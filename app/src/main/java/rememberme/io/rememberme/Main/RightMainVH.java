package rememberme.io.rememberme.Main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import rememberme.io.rememberme.R;

/**
 * Created by jongbong on 2017. 12. 11..
 */

public class RightMainVH extends RecyclerView.ViewHolder {

    ImageView image;
    TextView titleText;
    TextView scheduleText;

    public RightMainVH(View view) {
        super(view);
        image = (ImageView) view.findViewById(R.id.right_main_item_image);
        titleText = (TextView) view.findViewById(R.id.right_main_item_title);
        scheduleText = (TextView) view.findViewById(R.id.right_main_item_schedule);
    }
}
