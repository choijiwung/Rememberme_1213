package rememberme.io.rememberme.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by jongbong on 2017. 12. 11..
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public MainPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                LeftMainFragment leftMainFragment = new LeftMainFragment();
                return leftMainFragment;
            case 1:
                RightMainFragment rightMainFragment = new RightMainFragment();
                return rightMainFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
