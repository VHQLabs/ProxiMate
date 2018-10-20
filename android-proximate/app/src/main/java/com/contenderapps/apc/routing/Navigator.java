package com.contenderapps.apc.routing;


import android.content.Context;
import android.content.Intent;

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


}
