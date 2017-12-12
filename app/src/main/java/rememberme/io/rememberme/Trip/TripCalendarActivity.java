package rememberme.io.rememberme.Trip;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rememberme.io.rememberme.R;

import static com.squareup.timessquare.CalendarPickerView.SelectionMode.RANGE;

public class TripCalendarActivity extends AppCompatActivity {

    CalendarPickerView picker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_calendar);

        picker = (CalendarPickerView) findViewById(R.id.trip_calendar_picker);


        final Trip trip = new Trip();

        Calendar nextMonth = Calendar.getInstance();
        Calendar beforeYear = Calendar.getInstance();
        beforeYear.add(Calendar.MONTH, -1);
        nextMonth.add(Calendar.MONTH, 2);


        Date today = new Date();
        picker.init(beforeYear.getTime(), nextMonth.getTime()).withSelectedDate(today);
        picker.init(beforeYear.getTime(), nextMonth.getTime()).inMode(RANGE);

        picker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Log.i("aaDates", picker.getSelectedDates().toString());
                final List<Date> choiceDate = picker.getSelectedDates();

                if (picker.getSelectedDates().size() > 1) {
                    Date startDate = choiceDate.get(0);
                    Date endDate = choiceDate.get(choiceDate.size() - 1);

                    trip.setStart(startDate);
                    trip.setEnd(endDate);
                    AlertDialog.Builder alert = new AlertDialog.Builder(TripCalendarActivity.this);
                    alert.setTitle("일정 저장").setMessage("일정을 저장하시겠습니까?").setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    }).setNegativeButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setResult(Activity.RESULT_OK, new Intent().putExtra("trip", trip));
                            finish();
                        }
                    }).show();
                }
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }
}
