package com.contenderapps.apc.ui.home;


import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.data.repository.AppRepository;
import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;


public class HomePresenter extends BasePresenter<HomeMvpView> {

    private static final String TAG = HomePresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    private HomeMvpView tmpView;

    private boolean mIsActivated;


    @Inject
    AppRepository mAppRepository;

    public HomePresenter() {
        getPresenterComponent().inject(this);
        mIsFirstLoad = true;
    }

    @Override
    protected void restoreDataConfigurationChange() {
        // implement if needed
    }



    public void resume() {

    }




    public void setActivated(boolean isActivated) {
        mAppRepository.setActivated(isActivated);
    }

    public void checkActivated() {
        mIsActivated = mAppRepository.isActivated();
    }



    public void loadData() {
        if (mIsFirstLoad) {
            mIsFirstLoad = false;
//            startRequest();
        }
    }


}
