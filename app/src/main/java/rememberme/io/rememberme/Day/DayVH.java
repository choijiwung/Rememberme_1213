package rememberme.io.rememberme.Day;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import rememberme.io.rememberme.R;

/**
 * Created by jongbong on 2017. 12. 12..
 */

public class DayVH extends RecyclerView.ViewHolder {
    TextView title;

    public DayVH(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.day_item_title);
    }
}
