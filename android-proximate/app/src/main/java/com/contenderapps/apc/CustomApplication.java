package com.contenderapps.apc;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.analytics.EventNames;
import com.contenderapps.apc.analytics.EventsFactory;
import com.contenderapps.apc.analytics.trackers.FabricAnswersTracker;
import com.contenderapps.apc.analytics.trackers.FirebaseTracker;
import com.contenderapps.apc.injection.components.ApplicationComponent;
import com.contenderapps.apc.injection.components.DaggerApplicationComponent;
import com.contenderapps.apc.injection.modules.ApplicationModule;
import com.contenderapps.apc.injection.modules.DataModule;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.CrashlyticsCore;

import java.util.Locale;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;


public class CustomApplication extends Application {
//    public class CustomApplication extends Application implements HasActivityInjector {

    private static final String TAG = CustomApplication.class.getSimpleName();

    private ApplicationComponent mApplicationComponent;

    private static CustomApplication mInstance;

    public static CustomApplication get(Context context) {
        return (CustomApplication) context.getApplicationContext();
    }

    @Inject
    FirebaseTracker mFirebaseTracker;

//    @Inject
//    FabricAnswersTracker mFabricAnswersTracker;

    @Inject
    Analytics mAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();

        if (mInstance == null) {
            mInstance = this;
        }

        mApplicationComponent = buildApplicationComponent();

        mApplicationComponent.inject(this);


        // leak canary
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);

//        initCrashlyticsAnswers();

        mAnalytics.trackEvent(EventsFactory.shareApplication());
    }



    private void initCrashlyticsAnswers() {
        Crashlytics crashlytics = new Crashlytics.Builder()
                .core(
                        new CrashlyticsCore.Builder()
                                .disabled(BuildConfig.DEBUG)
                                .build()
                )
                .build();
        if (BuildConfig.DEBUG) {
            Fabric.with(mInstance, crashlytics);
        } else {
            Answers answers = Answers.getInstance();
            Fabric.with(mInstance, answers, crashlytics);
        }

    }



    private ApplicationComponent buildApplicationComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .build();
    }









    public static CustomApplication getInstance() {
        return mInstance;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                              Custom Exception Handler
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private static class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {

        private Thread.UncaughtExceptionHandler defaultUEH;

        public CustomExceptionHandler() {
            this.defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        }

        public void uncaughtException(Thread t, Throwable e) {
            Crashlytics.setString("VERSION.RELEASE", Build.VERSION.RELEASE);
            Crashlytics.setString("VERSION.INCREMENTAL", Build.VERSION.INCREMENTAL);
            Crashlytics.setString("VERSION.SDK", Integer.toString(Build.VERSION.SDK_INT));
            Crashlytics.setString("BOARD", Build.BOARD);
            Crashlytics.setString("BRAND", Build.BRAND);
            Crashlytics.setString("DEVICE", Build.DEVICE);
            Crashlytics.setString("FINGERPRINT", Build.FINGERPRINT);
            Crashlytics.setString("HOST", Build.HOST);
            Crashlytics.setString("ID", Build.ID);
            Crashlytics.logException(e);
            defaultUEH.uncaughtException(t, e);
        }
    }




}
