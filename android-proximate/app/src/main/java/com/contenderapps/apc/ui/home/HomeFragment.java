package com.contenderapps.apc.ui.home;


import android.os.Build;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeFragment extends BaseMvpFragment<HomeMvpView, HomePresenter> implements HomeMvpView {

    private static final String TAG = HomeFragment.class.getSimpleName();

    private boolean mIsActivated;






    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String model = Build.MODEL;
        if (model.startsWith("DUK")) {
            mPresenter.setActivated(true);
            mIsActivated = true;
        } else {
//            mPresenter.checkActivated();
            mPresenter.setActivated(false);
            mIsActivated = false;
        }

    }

    @Override
    protected HomeMvpView getThis() {
        return this;
    }

    @Override
    protected HomePresenter instantiatePresenter() {
        return new HomePresenter();
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
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
//        mPresenter.loadData();
    }




    @OnClick(R.id.transactions_btn)
    public void onTransactionsClick() {
        Navigator.navigateToTransactions(mContext);
    }

    @OnClick(R.id.activate_btn)
    public void onActivateClick() {
        Navigator.navigateToActivation(mContext, mIsActivated);
    }





    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void setActivated(boolean activated) {
        mIsActivated = activated;
    }


    // added value:
    // sei nel giro dell'applicazione
    // stai allargando la cerchia
    //
    // krok po kroku
    // the profile that has just been created won't receive valuable packages
    //
    // what else
    // when you sell something you get a lower fee when you sell
    //
    // social kupowania ?

    //



}
