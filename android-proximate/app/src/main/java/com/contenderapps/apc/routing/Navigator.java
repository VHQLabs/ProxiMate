package com.contenderapps.apc.routing;


import android.content.Context;
import android.content.Intent;

import com.contenderapps.apc.ui.authentication.AuthenticationActivity;
import com.contenderapps.apc.ui.home.HomeActivity;

/**
 * Class created to handle all the navigation between activities. This class knows how to open
 * every activity in the application and provides to the client code different methods to start
 * activities with the information needed.
 *
 * fixme: should this be injected ?
 * fixme: should this be a singleton ?
 */
// @Singleton
public class Navigator {



    public static void navigateToHome(Context context) {
        Intent intent = HomeActivity.getStartIntent(context);
        context.startActivity(intent);
    }

    public static void navigateToActivation(Context context, boolean mIsActivated) {
        Intent intent = AuthenticationActivity.getStartIntent(context);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra(AuthenticationActivity.EXTRA_ACTIVATED, mIsActivated);
        context.startActivity(intent);
    }

    public static void navigateToTransactions(Context context) {
        // TODO: 20/10/2018 - create a transactions activity 
        Intent intent = HomeActivity.getStartIntent(context);
        context.startActivity(intent);

    }
























}
