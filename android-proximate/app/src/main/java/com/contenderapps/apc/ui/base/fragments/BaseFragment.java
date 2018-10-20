package com.contenderapps.apc.ui.base.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import butterknife.Unbinder;

/**
 *
 *
 */
public class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    private Context mContext;

    protected Unbinder mUnbinder;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    /**
     * Shows a toast in the current context
     * @param s
     */
    public void showToast(String s) {
        Toast.makeText(mContext, s, Toast.LENGTH_LONG)
                .show();
    }
}
