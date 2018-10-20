package com.contenderapps.apc.data.datasource;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferencesDataSource {

    static final String KEY_FIRST_ACCESS = "KEY_FIRST_ACCESS";

    static final String KEY_IS_ACTIVATED = "KEY_IS_ACTIVATED";

    private final SharedPreferences mPref;

    @Inject
    public PreferencesDataSource(SharedPreferences sharedPreferences) {
        mPref = sharedPreferences;
    }

    public boolean getFirstAccess() {
        return mPref.getBoolean(KEY_FIRST_ACCESS, true);
    }

    public boolean saveFirstAccess(boolean firstAccess) {
        return setBoolean(KEY_FIRST_ACCESS, firstAccess);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }



    public boolean isActivated() {
        return mPref.getBoolean(KEY_IS_ACTIVATED, false);
    }

    public boolean setIsActivated(boolean isActivated) {
        return setBoolean(KEY_IS_ACTIVATED, isActivated);
    }





    /*
     *
     *      PRIVATE
     *      
     */
    private boolean setBoolean(String key, boolean data) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(key, data);
        return editor.commit();
    }

    private boolean setInt(String key, int data) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putInt(key, data);
        return editor.commit();
    }

    private boolean setString(String key, String data) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(key, data);
        return editor.commit();
    }






}
