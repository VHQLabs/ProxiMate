package com.contenderapps.apc.ui.authentication;


import android.os.Build;

import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.data.repository.AppRepository;
import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import javax.inject.Inject;


public class AuthenticationPresenter extends BasePresenter<AuthenticationMvpView> {

    private static final String TAG = AuthenticationPresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    private AuthenticationMvpView tmpView;

    private boolean isActivated;

    @Inject
    AppRepository mAppRepository;


    public AuthenticationPresenter() {
        getPresenterComponent().inject(this);
        mIsFirstLoad = true;


    }

    @Override
    protected void restoreDataConfigurationChange() {
        // implement if needed
    }



    public void resume() {
        // if the user is not activated show the qr page

        // if the user is activated show the scanning page
    }


    public void setActivated(boolean isActivated) {
        mAppRepository.setActivated(isActivated);
    }


    public void loadData() {
        if (mIsFirstLoad) {
            mIsFirstLoad = false;

        }
    }












}
