package com.contenderapps.apc.ui.authentication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;


public class AuthenticationActivity extends BaseToolbarActivity {

    private static final String TAG = AuthenticationActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, AuthenticationActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Home");

        if (savedInstanceState == null) {
//            replaceFragment(AuthenticationFragment.newInstance());
            replaceFragment(AuthenticationSecondFragment.newInstance());
        }
    }





}
