package com.contenderapps.apc.routing;


import android.content.Context;
import android.content.Intent;

import com.contenderapps.apc.ui.authentication.AuthenticationActivity;
import com.contenderapps.apc.ui.chat.ChatActivity;
import com.contenderapps.apc.ui.create.CreateActivity;
import com.contenderapps.apc.ui.deliverydetails.DeliveryActivity;
import com.contenderapps.apc.ui.home.HomeActivity;
import com.contenderapps.apc.ui.main.MainActivity;
import com.contenderapps.apc.ui.map.MapsActivity;

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
        Intent intent = MainActivity.getStartIntent(context);
        context.startActivity(intent);

    }

    public static void navigateToCreateRequest(Context context) {
        Intent intent = CreateActivity.getStartIntent(context);
        context.startActivity(intent);
    }

    public static void navigateToDeliveryDetails(Context context) {
        Intent intent = DeliveryActivity.getStartIntent(context);
        context.startActivity(intent);
    }

    public static void navigateToMap(Context context) {
        Intent intent = MapsActivity.getStartIntent(context);
        context.startActivity(intent);
    }


    public static void navigateToChat(Context context) {
        Intent intent = ChatActivity.getStartIntent(context);
        context.startActivity(intent);
    }
}
