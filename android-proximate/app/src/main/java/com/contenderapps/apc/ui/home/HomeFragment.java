package com.contenderapps.apc.ui.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contenderapps.apc.R;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;


public class HomeFragment extends BaseMvpFragment<HomeMvpView, HomePresenter> implements HomeMvpView {

    private static final String TAG = HomeFragment.class.getSimpleName();

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected HomeMvpView getThis() {
        return this;
    }

    @Override
    protected HomePresenter instantiatePresenter() {
        return new HomePresenter();
    }


//    @Override
//    protected int getFragmentLayout() {
//        return R.layout.fragment_splash;
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
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
//        mPresenter.loadData();
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////





}