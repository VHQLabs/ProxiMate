package com.contenderapps.apc.utils;

import android.app.Activity;
import android.content.Context;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.contenderapps.apc.ui.home.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

/**
 *
 *
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class CommonUtilsAndroidTest {


    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void getDeviceId() {
        Activity activity = mActivityTestRule.getActivity();
        String deviceId = CommonUtils.getDeviceId(activity);
        Log.d("info", "device id: " + deviceId);
        assertNotNull(deviceId);

    }
}
