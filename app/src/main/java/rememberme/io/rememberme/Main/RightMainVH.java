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
    TextView title;
    TextView schedule;

    public RightMainVH(View view) {
        super(view);
        image = (ImageView) view.findViewById(R.id.right_main_item_image);
        title = (TextView) view.findViewById(R.id.right_main_item_title);
        schedule = (TextView) view.findViewById(R.id.right_main_item_schedule);
    }
}
