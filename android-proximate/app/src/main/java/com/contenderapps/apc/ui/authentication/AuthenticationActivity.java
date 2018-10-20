package com.contenderapps.apc.ui.authentication;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.contenderapps.apc.data.repository.AppRepository;
import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;

import javax.inject.Inject;


public class AuthenticationActivity extends BaseToolbarActivity {

    private static final String TAG = AuthenticationActivity.class.getSimpleName();

    @Inject
    AppRepository mAppRepository;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, AuthenticationActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Log.d(TAG, "onCreate: " + mAppRepository);


//        if (Build.MODEL)




        String model = Build.MODEL;
        Log.d(TAG, "onCreate: " +  model);


        setToolbarTitle("Home");

        if (savedInstanceState == null) {
//            replaceFragment(AuthenticationFragment.newInstance());
            replaceFragment(AuthenticationSecondFragment.newInstance());
        }




    }





}
