package rememberme.io.rememberme.Main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import rememberme.io.rememberme.Network.APINetwork;
import rememberme.io.rememberme.Network.ApplicationController;
import rememberme.io.rememberme.Network.Token;
import rememberme.io.rememberme.Trip.Results.TIndexResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jongbong on 2017. 12. 11..
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int size;
    int tabCount;
    APINetwork network;

    Context context;

    public MainPagerAdapter(Context context, FragmentManager fm, int tabCount) {
        super(fm);
        this.context = context; // context 추가 12/11 05시 11분
        this.tabCount = tabCount;
        this.network = ApplicationController.getInstance().getApiNetwork();
    }

    @Override
    public Fragment getItem(int position) {
        // 탭 위치에 따라서 인플레이터
        switch (position) {
            case 0:
                LeftMainFragment leftMainFragment = new LeftMainFragment();
                return leftMainFragment;
            case 1:
                // 0일때하고 아닐때 구분해서 return 구분해서 하기.

                Token token = new Token(context); // 토큰 객체 생성
                Call<TIndexResult> tIndexResultCall = network.getTIndexResult(token.getKey()); //가져온 토큰을 네트워크에 보내서 다시 받는다.
                tIndexResultCall.enqueue(new Callback<TIndexResult>() { // 받아온 토큰을 바탕으로 콜백메소드 생성후
                    @Override
                    public void onResponse(Call<TIndexResult> call, Response<TIndexResult> response) {
                        TIndexResult result = response.body();
                        size = result.arrayList.size(); // 결과물의 size 여기서는 trip 사이즈를 알고,
                    }

                    @Override
                    public void onFailure(Call<TIndexResult> call, Throwable t) {
                    }
                });

                if (size != 0) { // trip의 사이즈가 0이 아니라면
                    RightMainFragment rightMainFragment = new RightMainFragment();
                    return rightMainFragment;
                } else { // trip의 사이즈가 0이면
                    RightMainNoFragment rightMainNoFragment = new RightMainNoFragment();
                    return rightMainNoFragment;
                }
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
