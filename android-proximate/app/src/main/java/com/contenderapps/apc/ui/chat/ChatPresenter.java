package com.contenderapps.apc.ui.chat;


import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import javax.inject.Inject;


public class ChatPresenter extends BasePresenter<ChatMvpView> {

    private static final String TAG = ChatPresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    private ChatMvpView tmpView;

    @Inject
    Analytics mAnalytics;

    public ChatPresenter() {
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
