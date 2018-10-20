package com.contenderapps.apc.injection.modules;

import android.content.Context;
import com.contenderapps.apc.CustomApplication;
import com.contenderapps.apc.injection.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Provides application-level dependencies.
 */

@Module
public class ApplicationModule {

    private final CustomApplication mApplication;

    public ApplicationModule(CustomApplication application) {
        mApplication = application;
    }


    @Provides
    @Singleton
    CustomApplication provideApplication() {
        return mApplication;
    }


    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }




}
