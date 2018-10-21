package com.contenderapps.apc.ui.create;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contenderapps.apc.R;
import com.contenderapps.apc.routing.Navigator;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class CreateFragment extends BaseMvpFragment<CreateMvpView, CreatePresenter> implements CreateMvpView {

    private static final String TAG = CreateFragment.class.getSimpleName();


    public static CreateFragment newInstance() {
        CreateFragment fragment = new CreateFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    protected CreateMvpView getThis() {
        return this;
    }

    @Override
    protected CreatePresenter instantiatePresenter() {
        return new CreatePresenter();
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_request, container, false);
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








    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////





}
