package com.contenderapps.apc.injection.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.injection.qualifiers.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 */
@Module
public class DataModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(@ApplicationContext Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    Analytics provideAnalytics(@ApplicationContext  Context context) {
        return new Analytics();
    }


}
