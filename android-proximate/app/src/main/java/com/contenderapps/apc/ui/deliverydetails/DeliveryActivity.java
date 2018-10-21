package com.contenderapps.apc.ui.deliverydetails;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;


public class DeliveryActivity extends BaseToolbarActivity {

    private static final String TAG = DeliveryActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DeliveryActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Home");

        if (savedInstanceState == null) {
            replaceFragment(DeliveryFragment.newInstance());
        }
    }
}
