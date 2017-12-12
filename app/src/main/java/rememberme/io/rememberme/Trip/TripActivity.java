package rememberme.io.rememberme.Trip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;

import rememberme.io.rememberme.Network.APINetwork;
import rememberme.io.rememberme.Network.ApplicationController;
import rememberme.io.rememberme.Network.Token;
import rememberme.io.rememberme.R;
import rememberme.io.rememberme.Trip.Results.TCreateResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripActivity extends AppCompatActivity {

    APINetwork network;
    EditText title;
    EditText region;
    EditText description;

    TextView start;
    TextView end;

    Button submit;

    Trip trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        network = ApplicationController.getInstance().getApiNetwork();

        title = (EditText) findViewById(R.id.container_title);
        region = (EditText) findViewById(R.id.container_region);
        description = (EditText) findViewById(R.id.container_description);

        start = (TextView) findViewById(R.id.container_btn_start);
        end = (TextView) findViewById(R.id.container_btn_end);

        submit = (Button) findViewById(R.id.container_btn_submit);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(TripActivity.this, TripCalendarActivity.class), 1000);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (trip != null) {
                    trip(title.getText().toString(), region.getText().toString(), description.getText().toString());
                } else {
                    Toast.makeText(TripActivity.this, "날짜를 선택해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                trip = (Trip) data.getSerializableExtra("trip");
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일", Locale.KOREA);
                String startDay = sdf.format(trip.getStart());
                String endDay = sdf.format(trip.getEnd());
                start.setText(startDay);
                end.setText(endDay);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    private void trip(String title, String region, String description) {
        Token token = new Token(TripActivity.this);
        trip.setTitle(title);
        trip.setRegion(region);
        trip.setDescription(description);
        Call<TCreateResult> tCreateResultCall = network.getTCreateResult(token.getKey(), trip);

        tCreateResultCall.enqueue(new Callback<TCreateResult>() {
            @Override
            public void onResponse(Call<TCreateResult> call, Response<TCreateResult> response) {
                // network success
                if (response.isSuccessful()) {
                    // work success


                    finish();
                } else {
                    // work fail
                }
            }

            @Override
            public void onFailure(Call<TCreateResult> call, Throwable t) {
                // network fail
            }
        });
    }
}
