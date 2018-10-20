package com.contenderapps.apc.ui.home;


import com.contenderapps.apc.ui.base.presenters.BasePresenter;

public class HomePresenter extends BasePresenter<HomeMvpView> {

    private static final String TAG = HomePresenter.class.getSimpleName();

    private boolean mOrientation;

    public HomePresenter() {

    }


    @Override
    public void attachView(HomeMvpView mvpView, boolean recreation) {
    }

    @Override
    public void detachView() {

    }

    @Override
    public boolean isViewAttached() {
        return false;
    }

    public boolean isOrientation() {
        return mOrientation;
    }

    public void setOrientation(boolean orientation) {
        mOrientation = orientation;
    }
}
