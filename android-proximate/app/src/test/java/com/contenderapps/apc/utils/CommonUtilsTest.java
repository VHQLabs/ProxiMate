package com.contenderapps.apc.utils;

import android.content.Context;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.*;

/**
 *
 *
 */
@RunWith(RobolectricTestRunner.class)
public class CommonUtilsTest {

    @Test
    public void isEmailValidTest() {
        String email = "username@example.com";
        boolean result = CommonUtils.isEmailValid(email);
        assertEquals(result, true);

        email = "user..name@example.com";
        result = CommonUtils.isEmailValid(email);
        assertEquals(result, false);
    }






}
