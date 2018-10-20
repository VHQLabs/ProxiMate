package com.contenderapps.apc.ui.splash;


import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class SplashPresenter extends BasePresenter<SplashMvpView> {

    private static final String TAG = SplashPresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    @Inject
    Analytics mAnalytics;

    public SplashPresenter() {
        getPresenterComponent().inject(this);
        mIsFirstLoad = true;
    }

    @Override
    protected void restoreDataConfigurationChange() {
        // implement if needed
    }



    public void resume() {
        // todo: navigate to home after 2s
        if (mIsFirstLoad) {
            mIsFirstLoad = false;
            Observable.just(new Object()).delay(2, TimeUnit.SECONDS)
                    .subscribe(new Observer<Object>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Object o) {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            getMvpView().navigateToHome();
                        }
                    })


            ;
        }
    }





}
