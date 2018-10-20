package com.contenderapps.apc.ui.authentication;


import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import javax.inject.Inject;


public class AuthenticationPresenter extends BasePresenter<AuthenticationMvpView> {

    private static final String TAG = AuthenticationPresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    private AuthenticationMvpView tmpView;

    @Inject
    Analytics mAnalytics;

    public AuthenticationPresenter() {
        getPresenterComponent().inject(this);
        mIsFirstLoad = true;
    }

    @Override
    protected void restoreDataConfigurationChange() {
        // implement if needed
    }



    public void resume() {

    }



    public void loadData() {
        if (mIsFirstLoad) {
            mIsFirstLoad = false;
//            startRequest();
        }
    }


}
