package com.contenderapps.apc.ui.splash;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.contenderapps.apc.R;
import com.contenderapps.apc.routing.Navigator;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;
import com.contenderapps.apc.ui.base.presenters.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.Objects;


public class SplashFragment extends BaseMvpFragment<SplashMvpView, SplashPresenter> implements SplashMvpView {

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
    protected SplashMvpView getThis() {
        return this;
    }

    @Override
    protected SplashPresenter instantiatePresenter() {
        return new SplashPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
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
    public void hideSoftKeyboard() {

    }

    @Override
    public void isAttached() {

    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void navigateToHome() {
        Navigator.navigateToHome(mContext);
        try {
            getActivity().finish();
        } catch (NullPointerException npe) {
            // todo: report to analytics
        }

    }




    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////











}
