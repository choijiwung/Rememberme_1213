package rememberme.io.rememberme.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import rememberme.io.rememberme.R;

/**
 * Created by jongbong on 2017. 12. 11..
 */

public class RightMainAdapter extends RecyclerView.Adapter<RightMainVH> {

    Context context;
    ArrayList<RightMainItem> arrayList = new ArrayList<RightMainItem>();

    public RightMainAdapter(Context context, ArrayList<RightMainItem> arrayList) {
        this.context = context;
        this.arrayList.addAll(arrayList);
    }


    // 인플레이터 하고
    @Override
    public RightMainVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_main_item, parent, false);
        return new RightMainVH(view);
    }


    // 가지고 있다.
    @Override
    public void onBindViewHolder(RightMainVH holder, int position) {
        holder.image.setImageResource(arrayList.get(position).image);
        //holder.image.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.titleText.setText(arrayList.get(position).title);
        holder.scheduleText.setText(arrayList.get(position).schedule);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
