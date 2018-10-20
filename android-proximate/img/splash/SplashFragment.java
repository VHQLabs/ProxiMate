package com.contenderapps.apc.ui.splash;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import com.contenderapps.apc.R;
import com.contenderapps.apc.routing.Navigator;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;


public class SplashFragment extends BaseMvpFragment<SplashPresenter> implements SplashMvpView {

    private static final String TAG = SplashFragment.class.getSimpleName();


    public static SplashFragment newInstance() {
        SplashFragment fragment = new SplashFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getMvpFragmentComponent(savedInstanceState).inject(this);
    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_splash;
    }


    @Override
    public void showLoading() {

    }


    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(@StringRes int resId) {

    }

    @Override
    public void onError(String message) {

    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadData();
    }

    @Override
    public void navigateToHome() {

    }
}
