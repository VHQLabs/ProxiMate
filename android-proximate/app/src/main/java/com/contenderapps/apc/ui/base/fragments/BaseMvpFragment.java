package com.contenderapps.apc.ui.base.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.CustomApplication;
import com.contenderapps.apc.ui.base.presenters.MvpView;
import com.contenderapps.apc.ui.base.presenters.Presenter;

/**
 *
 */

public abstract class BaseMvpFragment<V extends MvpView, P extends Presenter<V>> extends BaseFragment implements MvpView {

    private static final String TAG = BaseMvpFragment.class.getSimpleName();

    private BaseMvpFragmentInjector mInjector;

    protected P mPresenter;

    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInjector = new BaseMvpFragmentInjector();
        getApplication().getApplicationComponent().inject(mInjector);
        setupPresenter(savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupPresenter(savedInstanceState);
        mPresenter.activityCreated(savedInstanceState == null, getThis());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }







    protected abstract V getThis();

    /**
     *
     * @return Instantiated presenter by the subclass
     */
    protected abstract P instantiatePresenter();

    protected void setupPresenter(Bundle bundle) {
        if (mInjector.mPresenterManager != null) {
            if (bundle != null) {
                mPresenter = mInjector.mPresenterManager.restorePresenter(bundle);
            }

            if (mPresenter == null) {
                mPresenter = instantiatePresenter();
            }
        }
    }



    protected CustomApplication getApplication() {
        return ((CustomApplication) getActivity().getApplication());
    }

}
