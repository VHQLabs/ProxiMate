package com.contenderapps.apc.ui.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.contenderapps.apc.R;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;
import com.contenderapps.apc.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeMvpView {

    private static final String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.rv)
    RecyclerView mRv;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpFragmentComponent(savedInstanceState).inject(this);

        mPresenter.setOrientation(ViewUtils.isInLandscapeOrientation(mContext));

        DisplayMetrics dm = mContext.getApplicationContext()
                .getResources().getDisplayMetrics();
        float screenWidth = dm.widthPixels / dm.xdpi;
        float screenHeight = dm.heightPixels / dm.ydpi;
        Log.i(TAG, "onCreate: sw: " + screenWidth + " sh: " + screenHeight);
        Log.i(TAG, "onCreate: xdpi: " + dm.xdpi + " ydpi: " + dm.ydpi);
    }








    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // :adam: // TODO: 5/2/17 - load the data here
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home_tablet;
    }


}
