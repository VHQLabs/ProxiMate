package com.contenderapps.apc.ui.base.activities;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.contenderapps.apc.BuildConfig;
import com.contenderapps.apc.R;


public class BaseToolbarActivity extends BaseActivity {

    View mToolbarView;
    LinearLayout mToolbarContainer;
    Toolbar mToolbar;
    TextView mToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbarView = getLayoutInflater().inflate(R.layout.view_toolbar_title, null);
        mToolbarContainer = (LinearLayout) mToolbarView.findViewById(R.id.toolbar_container);

        mToolbar = (Toolbar) mToolbarView.findViewById(R.id.toolbar);
        mToolbarTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title_tv);

        setSupportActionBar(mToolbar);
    }


    /**
     * Sets the title of the toolbar.
     * @param title title to show in the toolbar
     */
    public void setToolbarTitle(String title) {
        mToolbarTitle.setPadding(0, mToolbarTitle.getPaddingTop(), mToolbarTitle.getPaddingRight(), mToolbarTitle.getPaddingBottom());
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mToolbarTitle.setText(Html.fromHtml(title));
        } else {
            mToolbarTitle.setText(Html.fromHtml(title, 0));
        }
        mToolbarTitle.setVisibility(View.VISIBLE);
        resizeToolbarTitle();
    }



    private void resizeToolbarTitle() {
        mToolbarTitle.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (mToolbarTitle.getWidth() > 0) {
                    mToolbarTitle.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    Context context = BaseToolbarActivity.this;

//                    int toolbarSpace = (BaseToolbarActivity.this instanceof BaseBackActivity || BaseToolbarActivity.this instanceof BaseDrawerActivity) ?
//                            context.getResources().getDimensionPixelSize(R.dimen.toolbar_left_space_drawer_back) :
//                            context.getResources().getDimensionPixelSize(R.dimen.toolbar_left_space);

//                    int paddingLeft = (HdxUiUtility.getScreenWidth(context) / 2) - (mToolBarTitle.getWidth() / 2) - toolbarSpace;
//                    mToolbarTitle.setPadding(paddingLeft, mToolBarTitle.getPaddingTop(), mToolBarTitle.getPaddingRight(), mToolBarTitle.getPaddingBottom());
                    mToolbarTitle.requestLayout();
                }
            }
        });
    }


}
