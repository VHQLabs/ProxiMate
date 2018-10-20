package com.contenderapps.apc.ui.base.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.contenderapps.apc.ui.base.presenters.BasePresenter;
import com.contenderapps.apc.ui.base.presenters.MvpView;


public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements MvpView {

//    @Inject
//    protected T mPresenter;
//
//    @Inject
//    PresenterManager mPresenterManager;

    private Bundle mBundle;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBundle = savedInstanceState;
        if (mPresenter != null && !mPresenter.isViewAttached()) {
            mPresenter.attachView(this, mBundle != null);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null && !mPresenter.isViewAttached()) {
            mPresenter.attachView(this, mBundle != null);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.detachView();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenterManager == null) {
            return;
        }
        // here we save the presenter before the fragment is destroyed / stopped
        mPresenterManager.savePresenter(mPresenter, outState);
    }

    public MvpFragmentComponent getMvpFragmentComponent(Bundle bundle) {
////        return DaggerMvpFragmentComponent.builder()
////                .mvpFragmentModule(new MvpFragmentModule(bundle))
////                .applicationComponent(AppApplication.get(getActivity()).getComponent())
////                .build();
        return null;
    }


    @Override
    public void hideSoftKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager)
                    getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public void showLoading() {
        // TODO: 4/28/17 implement 
    }

    public void hideLoading() {
        // TODO: 4/28/17 implement

    }

    public void onError(@StringRes int resId) {
        // TODO: 4/28/17 implement

    }

    public void onError(String message) {
        // TODO: 4/28/17 implement

    }


}
