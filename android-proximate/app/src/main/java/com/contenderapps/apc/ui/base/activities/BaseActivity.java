package com.contenderapps.apc.ui.base.activities;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.contenderapps.apc.R;


/**
 * The activity only acts as the host to 1 or more fragments for inter-fragment communication.
 * All views and logic are in fragments. This leads to a modular and reusable
 * architecture as well as a simpler MVP architecture
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frame);

    }



    public void showLoading() {

    }

    public void hideLoading() {
//        super.hideL
    }






    protected final void addFragment(@IdRes int containerViewId, Fragment fragment) {
//        mFragmentManager.beginTransaction()
//                .add(containerViewId, fragment)
//                .commit();
    }



    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }










}
