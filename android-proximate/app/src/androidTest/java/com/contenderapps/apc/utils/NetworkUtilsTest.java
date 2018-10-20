package com.contenderapps.apc.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.contenderapps.apc.ui.home.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 *
 *
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class NetworkUtilsTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void isNetworkAvailableTest() {
//        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        wifi.setWifiEnabled(true);
        Context context = mActivityTestRule.getActivity();
        boolean isConnected = NetworkUtils.isNetworkConnected(context);
        assertEquals(isConnected, true);

    }



}
