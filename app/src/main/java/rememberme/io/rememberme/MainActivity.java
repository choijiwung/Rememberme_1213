package rememberme.io.rememberme;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LeftMainFragment mainFragmentLeftCurrentTrip;
    RightMainFragment mainFragmentRightTripList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout actionbar_linear = (LinearLayout) findViewById(R.id.actionbar_linear);




//        toolbar=(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar); // xml의 레이아웃으로 만든 툴바를  액션바로 설정
//
//        getSupportActionBar();

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 하기 위해 필요
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
//        actionBar.setHomeAsUpIndicator(R.drawable.logo); //뒤로가기 버튼을 본인이 만든 아이콘으로 하기 위해 필요

        mainFragmentLeftCurrentTrip = new LeftMainFragment();
        mainFragmentRightTripList = new RightMainFragment();


        getSupportFragmentManager().beginTransaction().add(R.id.main_container, mainFragmentLeftCurrentTrip).commit();

        // 이제 탭버튼을 추가

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("현재여행"));
        tabs.addTab(tabs.newTab().setText("여행목록"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {  // 탭버튼을 하나 선택했을 때 자동으로 선택되는 콜벡메소드
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position==0){
                    selected = mainFragmentLeftCurrentTrip;
                }else if (position == 1) {
                    selected = mainFragmentRightTripList;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container,selected).commit(); // 이미 선택되었기 때문에, replace를 사용하며, 뜻은 container 안에 선택된 selected를 넣어주라
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
//    //툴바에 메뉴 활성화
//      public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }


}
