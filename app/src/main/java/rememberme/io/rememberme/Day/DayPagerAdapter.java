package rememberme.io.rememberme.Day;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by jongbong on 2017. 12. 12..
 */

public class DayPagerAdapter extends FragmentStatePagerAdapter {

    Context context;
    ArrayList<Day> arrayList = new ArrayList<>();


    public DayPagerAdapter(Context context, FragmentManager fm, ArrayList<Day> arrayList) {
        super(fm);
        this.context = context;
        this.arrayList.addAll(arrayList);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == arrayList.size()) {
            return new DayNoFragment();
        } else {
            return new DayFragment(arrayList.get(position), arrayList.size());
        }
    }

    @Override
    public int getCount() {
        return arrayList.size() + 1;
    }
}
