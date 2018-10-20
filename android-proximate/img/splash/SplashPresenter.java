package com.contenderapps.apc.ui.splash;


import android.util.Log;

import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class SplashPresenter extends BasePresenter<SplashMvpView> {

    private static final String TAG = SplashPresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    private SplashMvpView tmpView;


    public SplashPresenter() {
        mIsFirstLoad = true;
    }


    @Override
    public void detachView() {
        Log.i(TAG, "detachView: ");
    }


    private void startRequest() {
        Observable.just(new Object())
                // FIXME: 5/14/17  - change teh splash timing
                .delay(0, TimeUnit.SECONDS)
//                .compose(this.handleDataRequest())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i(TAG, "call: ");
                    }
                })
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        SplashMvpView mvpView = getMvpView();
                        tmpView = getMvpView();
                        Log.i(TAG, "call: ");
                        tmpView.navigateToHome();
                    }
                })
                .subscribe();
    }

    public void loadData() {
        if (mIsFirstLoad) {
            mIsFirstLoad = false;
            startRequest();
        }
    }
}
