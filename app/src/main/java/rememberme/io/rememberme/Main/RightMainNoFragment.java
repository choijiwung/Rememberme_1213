package rememberme.io.rememberme.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import rememberme.io.rememberme.R;
import rememberme.io.rememberme.Trip.TripActivity;

/**
 * Created by samsung on 2017-12-11.
 */

public class RightMainNoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_right_no_main, container, false);


        Button btnAddPlan = (Button) view.findViewById(R.id.btnAddPlan);
        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getContext(),"여기서 fragment_tip.xml로 넘어가야됨.",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(), TripActivity.class));
            }
        });

        return view;
    }
}
