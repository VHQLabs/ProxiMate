package com.contenderapps.apc.ui.base.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.contenderapps.apc.R;


public class MasterDetailActivity extends BaseToolbarActivity {

    private static final String TAG = MasterDetailActivity.class.getSimpleName();

    private boolean mIsTwoPane = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_master_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        // wtf is this ?
        setToolbarTitle("often");

        if (findViewById(R.id.detail) != null) {
            mIsTwoPane = true;
        }
    }


    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

    public void replaceDetailFragment(Fragment fragment) {
        if (mIsTwoPane) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail, fragment)
                    .commit();
        }
    }


}
