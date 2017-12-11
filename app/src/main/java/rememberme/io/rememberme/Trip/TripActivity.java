package rememberme.io.rememberme.Trip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rememberme.io.rememberme.R;

public class TripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        getSupportFragmentManager().beginTransaction().add(R.id.trip_container, new TripContainerFragment()).commit();
    }
}
