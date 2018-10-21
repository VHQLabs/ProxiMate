package com.contenderapps.apc.ui.map;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;

import com.contenderapps.apc.R;

public class MapsActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Map");

        if (savedInstanceState == null) {
            replaceFragment(MapFragment.newInstance());
        }
    }
}
