package com.contenderapps.apc.ui.base.presenters;


import com.contenderapps.apc.CustomApplication;
import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.injection.components.DaggerPresenterComponent;
import com.contenderapps.apc.injection.components.PresenterComponent;

import javax.inject.Inject;

public abstract class BasePresenter<V extends MvpView> implements Presenter<V> {

    private static final String TAG = BasePresenter.class.getSimpleName();


    private PresenterComponent mPresenterComponent;
    private V mMvpView;

    // todo implement with rxjava 2
    // CompositeDisposable rxjava2



    public BasePresenter() {
        mPresenterComponent = DaggerPresenterComponent.builder()
                .applicationComponent(CustomApplication.getInstance().getApplicationComponent())
                .build();
    }


    @Override
    public void activityCreated(boolean isFirstTime, V view) {
        mMvpView = view;

        if (!isFirstTime) {
            restoreDataConfigurationChange();
        }
    }


    @Override
    public void viewAttached() {
        // resume rx java subscriptions
    }

    @Override
    public void viewDetached() {
        // dispose of rx java subscriptions
    }

    protected V getMvpView() {
        return mMvpView;
    }



    protected abstract void restoreDataConfigurationChange();



    protected PresenterComponent getPresenterComponent() {
        return mPresenterComponent;
    }


}
