package com.contenderapps.apc.ui.create;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;


public class CreateActivity extends BaseToolbarActivity {

    private static final String TAG = CreateActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, CreateActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Home");

        if (savedInstanceState == null) {
            replaceFragment(CreateFragment.newInstance());
        }
    }
}
