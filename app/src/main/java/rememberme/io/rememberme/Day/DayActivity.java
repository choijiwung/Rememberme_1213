package rememberme.io.rememberme.Day;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rememberme.io.rememberme.Day.Results.DPageResult;
import rememberme.io.rememberme.Network.APINetwork;
import rememberme.io.rememberme.Network.ApplicationController;
import rememberme.io.rememberme.Network.Token;
import rememberme.io.rememberme.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DayActivity extends AppCompatActivity {

    APINetwork network;

    ViewPager pager;
    DayPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Intent intent = getIntent();
        int tid = intent.getExtras().getInt("tid");

        network = ApplicationController.getInstance().getApiNetwork();
        pager = (ViewPager) findViewById(R.id.day_pager);

        getDays(tid);

    }

    private void getDays(int tid) {
        Call<DPageResult> dPageResultCall = network.getDPageResult(new Token(this).getKey(), tid, 1);
//        Call<DIndexResult> dIndexResultCall = network.getDIndexResult(new Token(this).getKey(), tid);
//        dIndexResultCall.enqueue(new Callback<DIndexResult>() {
        dPageResultCall.enqueue(new Callback<DPageResult>() {
            @Override
            public void onResponse(Call<DPageResult> call, Response<DPageResult> response) {
                if (response.isSuccessful()) {
                    Log.i("Day", "Success / code : " + response.code());
                    DPageResult dPageResult = response.body();
                    adapter = new DayPagerAdapter(DayActivity.this, getSupportFragmentManager(), dPageResult.result);
                    pager.setAdapter(adapter);
                } else {
                    Log.i("Day", "Fail / code : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<DPageResult> call, Throwable t) {
                Log.i("Day", "errors : ".concat(t.getMessage()));
            }
        });
    }
}
