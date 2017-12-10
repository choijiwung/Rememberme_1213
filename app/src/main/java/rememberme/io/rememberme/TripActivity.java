package rememberme.io.rememberme;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static rememberme.io.rememberme.R.id.btnStartDay;

/**
 * Created by samsung on 2017-12-11.
 */
// 여기서 버튼을 누르면 달력이 나오고, 달력을 설정해서 데이 숫자가 넘어와야한다.
public class TripActivity {
    AddTitleActivity addTitleActivity;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup addTitle = (ViewGroup) inflater.inflate(R.layout.fragment_add_title,container,false);

        Button startDay = (Button) addTitle.findViewById(btnStartDay);
        startDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTitleActivity = (AddTitleActivity) getActivity();
                addTitleActivity.addTitle_to_Calender(0);
            }
        });
        return addTitle;
    }
}
