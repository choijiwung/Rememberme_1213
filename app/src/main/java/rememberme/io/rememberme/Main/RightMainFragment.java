package rememberme.io.rememberme.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import rememberme.io.rememberme.R;

/**
 * Created by samsung on 2017-11-17.
 */
// 여행목록 탭
public class RightMainFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { //레이아웃을 인플레이터 할수 있게하는 메소드
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_right_main, container, false); // false는 바로 붙이지 않고, 동작할때만 붙일 수있게

        fab = (FloatingActionButton) view.findViewById(R.id.right_main_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.right_main_recycler);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        ArrayList<RightMainItem> items = new ArrayList<>();
        items.add(new RightMainItem(R.drawable.logo, "바닷가 여행", "2017.07.08 - 2017.07.20"));
        items.add(new RightMainItem(R.drawable.logo, "바닷가 여행", "2017.07.08 - 2017.07.20"));
        items.add(new RightMainItem(R.drawable.logo, "바닷가 여행", "2017.07.08 - 2017.07.20"));
        items.add(new RightMainItem(R.drawable.logo, "바닷가 여행", "2017.07.08 - 2017.07.20"));

        RightMainAdapter adapter = new RightMainAdapter(getContext(), items);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        return view;

    }
}