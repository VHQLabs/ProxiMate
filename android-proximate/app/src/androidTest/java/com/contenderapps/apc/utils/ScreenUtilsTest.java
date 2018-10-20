package com.contenderapps.apc.utils;

import android.content.Context;
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
public class ScreenUtilsTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void getScreenSizeTest() {
        Context context = mActivityTestRule.getActivity();
        int screenHeight = ScreenUtils.getScreenHeight(context);
        int screenWidth = ScreenUtils.getScreenWidth(context);
        boolean result = (screenHeight > 0 && screenWidth > 0);
        assertEquals(result, true);
    }


    @Test
    public void getStatusBarHeightTest() {
        Context context = mActivityTestRule.getActivity();
        boolean result =  (ScreenUtils.getStatusBarHeight(context) > 0);
        assertEquals(result, true);
    }



}
