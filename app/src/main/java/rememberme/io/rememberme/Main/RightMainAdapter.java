package rememberme.io.rememberme.Main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import rememberme.io.rememberme.Day.DayActivity;
import rememberme.io.rememberme.R;
import rememberme.io.rememberme.Trip.Trip;

/**
 * Created by jongbong on 2017. 12. 11..
 */

public class RightMainAdapter extends RecyclerView.Adapter<RightMainVH> {

    Context context;
    ArrayList<Trip> arrayList = new ArrayList<Trip>();

    public RightMainAdapter(Context context, ArrayList<Trip> arrayList) {
        this.context = context;
        this.arrayList.addAll(arrayList);
        Log.i("Main", "Constructor size : " + this.arrayList.size());
    }

    @Override
    public RightMainVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_main_item, parent, false);
        return new RightMainVH(view);
    }

    @Override
    public void onBindViewHolder(RightMainVH holder, final int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd", Locale.KOREA);

        holder.image.setImageResource(arrayList.get(position).getThumb());
        holder.title.setText(arrayList.get(position).getTitle());
        holder.schedule.setText(sdf.format(arrayList.get(position).getStart()) + " - " + sdf.format(arrayList.get(position).getEnd()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DayActivity.class);
                intent.putExtra("tid", arrayList.get(position).getId());
                Log.i("Main", "RightMainAdapter tid : " + arrayList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
