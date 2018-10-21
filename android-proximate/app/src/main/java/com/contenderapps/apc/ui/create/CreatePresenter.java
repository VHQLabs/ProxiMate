package com.contenderapps.apc.ui.create;


import com.contenderapps.apc.data.repository.AppRepository;
import com.contenderapps.apc.ui.base.presenters.BasePresenter;

import javax.inject.Inject;


public class CreatePresenter extends BasePresenter<CreateMvpView> {

    private static final String TAG = CreatePresenter.class.getSimpleName();

    private boolean mIsFirstLoad;

    private CreateMvpView tmpView;



    @Inject
    AppRepository mAppRepository;

    public CreatePresenter() {
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
