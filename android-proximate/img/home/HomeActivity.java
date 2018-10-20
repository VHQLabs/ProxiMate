package com.contenderapps.apc.ui.home;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;


public class HomeActivity extends BaseToolbarActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//         TODO: 4/20/17 add the possibility of setting the mTitleStringRes easily
        setToolbarTitle("hello there");

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment.newInstance());
        }
    }
}
