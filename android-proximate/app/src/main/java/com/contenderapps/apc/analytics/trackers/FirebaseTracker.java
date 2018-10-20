package com.contenderapps.apc.analytics.trackers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.analytics.model.Event;
import com.contenderapps.apc.injection.qualifiers.ApplicationContext;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.observers.DisposableObserver;


/**
 * We use Pair<String, Bundle> instead of FirebaseAnalytics.Event because that class (Event) is used
 * only as a placeholder for event names.
 */
@Singleton
public class FirebaseTracker extends AbstractTracker<Pair<String, Bundle>> {

    private static final String TAG = FirebaseTracker.class.getSimpleName();

    private Analytics mAnalytics;
    private DisposableObserver<Pair<String, Bundle>> mEventsDisposable;

    @Inject
    public FirebaseTracker(@ApplicationContext Context context, Analytics analytics) {
        super(context, analytics);
        mAnalytics = analytics;

        if (isInterestedInEvents()) {
            subscribeToEvents();
        }
    }

    @Override
    protected boolean isInterestedInEvents() {
        return true;
    }

    @Override
    protected boolean isInterestedInUserProperties() {
        return false;
    }

    @Override
    boolean acceptEvent(@Nonnull Event event) {
        return true;
    }





    private void subscribeToEvents() {
        mEventsDisposable = mAnalytics.eventStream()
                .filter(this::acceptEvent)
//                .doOnNext(this::logEvent)
                .map(this::transformEvent)
                .subscribeWith(new DisposableObserver<Pair<String, Bundle>>() {

                    @Override
                    public void onNext(Pair<String, Bundle> event) {
                        postEvent(event);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        // Log the error
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @NonNull
    @Override
    Pair<String, Bundle> transformEvent(@NonNull Event event) {
        Bundle bundle = new Bundle();
        if (event.params != null) {
            for (String s : event.params.keySet()) {
                bundle.putString(s, event.params.get(s));
            }
        }
        return new Pair<>(event.name, bundle);
    }


    @Override
    void postEvent(@NonNull Pair<String, Bundle> event) {
    }




}
