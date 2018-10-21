package com.contenderapps.apc.ui.main;


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


public class RequestsFragment extends BaseMvpFragment<MainMvpView, MainPresenter> implements MainMvpView {

    private static final String TAG = RequestsFragment.class.getSimpleName();

    private MainMenuInterface mMainInterface;



    public static RequestsFragment newInstance() {
        RequestsFragment fragment = new RequestsFragment();
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
        View view = inflater.inflate(R.layout.fragment_requests, container, false);
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
    @OnClick(R.id.add_btn)
    public void onAddClicked() {
        Navigator.navigateToCreateRequest(mContext);
    }



}
