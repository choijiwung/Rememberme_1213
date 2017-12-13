package rememberme.io.rememberme.Day;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import rememberme.io.rememberme.R;

/**
 * Created by jongbong on 2017. 12. 12..
 */

public class DayAdapter extends RecyclerView.Adapter<DayVH> {

    Context context;
    ArrayList<String> spotName = new ArrayList<>();

    public DayAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.spotName.addAll(arrayList);
    }


    @Override
    public DayVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.day_item, parent, false);
        return new DayVH(view);
    }

    @Override
    public void onBindViewHolder(DayVH holder, int position) {
        holder.title.setText(spotName.get(position));
    }

    @Override
    public int getItemCount() {
        return spotName.size();

    }
}
