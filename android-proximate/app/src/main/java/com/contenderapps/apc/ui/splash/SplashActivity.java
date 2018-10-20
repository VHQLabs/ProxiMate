package com.contenderapps.apc.ui.splash;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;


public class SplashActivity extends BaseToolbarActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);


        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: 4/22/17 - automate the setting of a mTitleStringRes
        setToolbarTitle(SplashActivity.class.getName());

        if (savedInstanceState == null) {
            replaceFragment(SplashFragment.newInstance());
        }
    }
}
