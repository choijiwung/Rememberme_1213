package rememberme.io.rememberme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by samsung on 2017-12-11.
 */

public class RightNolistMainFragment extends Fragment {
    MainActivity mainActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { //레이아웃을 인플레이터 할수 있게하는 메소드
        final ViewGroup rootView   = (ViewGroup) inflater.inflate (R.layout.fragment_right_nolist_main, container, false); // false는 바로 붙이지 않고, 동작할때만 붙일 수있게

        Button BtnAddTitle = (Button) rootView.findViewById(R.id.btnAddPlan);
        BtnAddTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewGroup)(rootView.getParent())).removeView(rootView);
                Intent goToAddTitleActivity = new Intent(getActivity(), AddTitleActivity.class);
                getActivity().startActivity(goToAddTitleActivity);
            }
        });
        return rootView;


    }

}
