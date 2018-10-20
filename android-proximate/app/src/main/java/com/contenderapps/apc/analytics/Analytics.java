package com.contenderapps.apc.analytics;

import android.support.annotation.NonNull;
import com.contenderapps.apc.analytics.contract.EventsStreamProvider;
import com.contenderapps.apc.analytics.contract.PropertiesStreamProvider;
import com.contenderapps.apc.analytics.model.Event;
import com.contenderapps.apc.analytics.model.UserProperty;
import javax.annotation.Nonnull;
import javax.inject.Singleton;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;


/**
 * todo: inject with dagger
 */
@Singleton
public class Analytics implements EventsStreamProvider, PropertiesStreamProvider {

    private static final String TAG = Analytics.class.getSimpleName();


    private PublishSubject<Event> eventPublishSubject;

    private PublishSubject<UserProperty>    userPropertyPublishSubject;

    private static Analytics sInstance;



    public static Analytics getInstance() {
        if (sInstance == null) {
            sInstance = new Analytics();
        }
        return sInstance;
    }


    public Analytics() {
        eventPublishSubject = PublishSubject.create();
        userPropertyPublishSubject = PublishSubject.create();

        // further init if required
    }



    public void trackEvent(@NonNull Event event) {
        eventPublishSubject.onNext(event);
    }


    public void updateUserProperty(@NonNull UserProperty userProperty) {
        userPropertyPublishSubject.onNext(userProperty);
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                            Stream Provider Interface
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    @Nonnull
    public Observable<Event> eventStream() {
        return eventPublishSubject;
    }


    @Override
    @Nonnull
    public Observable<UserProperty> propertyStream() {
        return userPropertyPublishSubject;
    }

}
