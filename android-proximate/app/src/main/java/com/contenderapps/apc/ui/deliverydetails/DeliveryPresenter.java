package com.contenderapps.apc.ui.deliverydetails;


import com.contenderapps.apc.data.repository.AppRepository;
import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import javax.inject.Inject;


public class DeliveryPresenter extends BasePresenter<DeliveryMvpView> {

    private static final String TAG = DeliveryPresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    private DeliveryMvpView tmpView;



    @Inject
    AppRepository mAppRepository;

    public DeliveryPresenter() {
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
