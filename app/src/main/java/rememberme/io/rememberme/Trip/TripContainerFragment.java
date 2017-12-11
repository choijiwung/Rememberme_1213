package rememberme.io.rememberme.Trip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import rememberme.io.rememberme.R;

/**
 * Created by jongbong on 2017. 12. 11..
 */

public class TripContainerFragment extends Fragment {

    EditText title;
    EditText region;
    EditText description;

    TextView start;
    TextView end;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_container, container, false);

        title = (EditText) view.findViewById(R.id.container_title);
        region = (EditText) view.findViewById(R.id.container_region);
        description = (EditText) view.findViewById(R.id.container_description);

        start = (TextView) view.findViewById(R.id.container_btn_start);
        end = (TextView) view.findViewById(R.id.container_btn_end);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.trip_calendar, new TripCalendarFragment()).commit();
            }
        });

        return view;
    }
}
