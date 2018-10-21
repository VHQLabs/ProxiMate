package com.contenderapps.apc.ui.authentication;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.contenderapps.apc.data.repository.AppRepository;
import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;

import javax.inject.Inject;


public class AuthenticationActivity extends BaseToolbarActivity implements ActivatedInterface {

    private static final String TAG = AuthenticationActivity.class.getSimpleName();

    public static final String EXTRA_ACTIVATED = "extra_activated";

    private boolean mIsActivated;
    private String mQRString;

    @Inject
    AppRepository mAppRepository;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, AuthenticationActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // todo: get the is activated extra
        mIsActivated = getIntent().getBooleanExtra(EXTRA_ACTIVATED, false);

        if (savedInstanceState == null) {
            if (mIsActivated) {
                // start with the scanning fragment
                replaceFragment(AuthenticationFragment.newInstance());
            } else {
                // start with the qr fragment
                replaceFragment(AuthenticationSecondFragment.newInstance());
            }
        }
        setToolbarTitle("Home");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                      ActivatedInterface
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean isActivated() {
        return mIsActivated;
    }

    @Override
    public void setQRString(String qr) {
        mQRString = qr;
    }

    @Override
    public String getQRString() {
        return mQRString;
    }

    @Override
    public void changeToQRFragment() {
        replaceFragment(AuthenticationSecondFragment.newInstance());
    }

    @Override
    public void changeToCameraFragment() {
        replaceFragment(AuthenticationFragment.newInstance());
    }
}
