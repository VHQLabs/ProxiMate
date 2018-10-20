package com.contenderapps.apc.ui.transactions;


import com.contenderapps.apc.data.repository.AppRepository;
import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import javax.inject.Inject;


public class TransactionsPresenter extends BasePresenter<TransactionsMvpView> {

    private static final String TAG = TransactionsPresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    private TransactionsMvpView tmpView;

    private boolean mIsActivated;


    @Inject
    AppRepository mAppRepository;

    public TransactionsPresenter() {
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
