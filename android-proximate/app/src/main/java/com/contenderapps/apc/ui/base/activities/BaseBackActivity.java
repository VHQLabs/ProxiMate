package com.contenderapps.apc.ui.base.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.contenderapps.apc.R;


/**
 *
 *
 */
public class BaseBackActivity extends BaseToolbarActivity {

    private static final String TAG = BaseBackActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());

        RelativeLayout rootView = (RelativeLayout) findViewById(R.id.activity_container);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        rootView.addView(mToolbarView, params);
    }
}
