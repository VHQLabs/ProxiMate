package com.contenderapps.apc.ui.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contenderapps.apc.R;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;


public class ChatFragment extends BaseMvpFragment<ChatMvpView, ChatPresenter> implements ChatMvpView {

    private static final String TAG = ChatFragment.class.getSimpleName();

    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ChatMvpView getThis() {
        return this;
    }

    @Override
    protected ChatPresenter instantiatePresenter() {
        return new ChatPresenter();
    }


//    @Override
//    protected int getFragmentLayout() {
//        return R.layout.fragment_splash;
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
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
