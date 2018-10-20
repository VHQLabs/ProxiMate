package com.contenderapps.apc.ui.base.presenters;


import android.support.annotation.StringRes;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    // TODO: 4/20/17 find an alternative to check whether we're connected to the net
//    boolean isNetworkConnected();

    void hideSoftKeyboard();

    void showToast(String s);

    void isAttached();
}
