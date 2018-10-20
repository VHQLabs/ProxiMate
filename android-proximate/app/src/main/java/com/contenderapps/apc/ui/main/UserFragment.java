package com.contenderapps.apc.ui.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contenderapps.apc.R;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;

import butterknife.ButterKnife;


public class UserFragment extends BaseMvpFragment<MainMvpView, MainPresenter> implements MainMvpView {

    private static final String TAG = UserFragment.class.getSimpleName();

    private MainMenuInterface mMainInterface;


    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainInterface = (MainMenuInterface) this.getActivity();
    }

    @Override
    protected MainMvpView getThis() {
        return this;
    }

    @Override
    protected MainPresenter instantiatePresenter() {
        return new MainPresenter();
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
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









    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////



}
