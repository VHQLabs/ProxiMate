package com.contenderapps.apc.data.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.assertEquals;

/**
 * Testing preferences data source.
 */
@RunWith(RobolectricTestRunner.class)
public class PreferencesDataSourceTest {

    @Test
    public void testFirstAccess() {
        SharedPreferences sharedPreferences = RuntimeEnvironment.application
                .getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        PreferencesDataSource pds = new PreferencesDataSource(sharedPreferences);

        pds.saveFirstAccess(false);
        assertEquals(pds.getFirstAccess(), false);
        pds.saveFirstAccess(true);
        assertEquals(pds.getFirstAccess(), true);
    }


    @Test
    public void testClearPreferences() {
        SharedPreferences sharedPreferences = RuntimeEnvironment.application
                .getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        PreferencesDataSource pds = new PreferencesDataSource(sharedPreferences);

        // by default it's true
        assertEquals(pds.getFirstAccess(), true);
        pds.saveFirstAccess(false);
        assertEquals(pds.getFirstAccess(), false);
        pds.clear();
        assertEquals(pds.getFirstAccess(), true);
    }




}
