package com.contenderapps.apc.ui.map;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;

import com.contenderapps.apc.R;
import com.contenderapps.apc.ui.deliverydetails.DeliveryActivity;

public class MapsActivity extends BaseToolbarActivity {


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MapsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Map");

        if (savedInstanceState == null) {
            replaceFragment(MapFragment.newInstance());
        }
    }
}
