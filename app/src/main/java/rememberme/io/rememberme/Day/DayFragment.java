package rememberme.io.rememberme.Day;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import rememberme.io.rememberme.R;

public class DayFragment extends Fragment {

    TextView seq;
    TextView max;
    TextView alias;

    RecyclerView recycler;
    RecyclerView.LayoutManager manager;
    DayAdapter adapter;

    Day day;
    int maxCount;

    public DayFragment(Day day, int maxCount) {
        this.day = day;
        this.maxCount = maxCount;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_day, container, false);

        seq = (TextView) view.findViewById(R.id.day_seq);
        max = (TextView) view.findViewById(R.id.day_max);
        alias = (TextView) view.findViewById(R.id.day_alias);

        seq.setText(day.getSeq()+"");
        max.setText(maxCount+"");
        alias.setText(day.getAlias()+"");

        recycler = (RecyclerView) view.findViewById(R.id.day_recycler);
        manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        // adapter = new DayAdapter(getContext(), day.getSpotNames());
        adapter = new DayAdapter(getContext(), new ArrayList<String>());

        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);

        return view;
    }
}
