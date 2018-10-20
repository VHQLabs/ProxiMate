package com.contenderapps.apc.ui.transactions;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;


public class TransactionsActivity extends BaseToolbarActivity {

    private static final String TAG = TransactionsActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, TransactionsActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Home");

        if (savedInstanceState == null) {
            replaceFragment(TransactionsFragment.newInstance());
        }
    }
}
