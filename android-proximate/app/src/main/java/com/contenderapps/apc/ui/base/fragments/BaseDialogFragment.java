package com.contenderapps.apc.ui.base.fragments;


import android.support.v4.app.Fragment;

import butterknife.Unbinder;

public class BaseDialogFragment extends Fragment {


    protected Unbinder mUnbinder;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
