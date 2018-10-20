package com.contenderapps.apc.analytics.trackers;


import android.content.Context;
import android.support.annotation.NonNull;
import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.analytics.model.Event;
import io.reactivex.observers.DisposableObserver;

public abstract class AbstractTracker<E> {

    protected Analytics mAnalytics;

    protected DisposableObserver<E> mEventsDisposable;

    protected Context mContext;


    public AbstractTracker(Context context, Analytics analytics) {
        mContext = context;
        mAnalytics = analytics;

        if (isInterestedInEvents()) {
//            subscribeToEvents();
        }

        if (isInterestedInUserProperties()) {
//            subscribeToUserProperties();
        }
    }

    protected abstract boolean isInterestedInEvents();

    protected abstract boolean isInterestedInUserProperties();

    /**
     * Called during initialization
     */
//    void subscribeToEvents() {
//        mEventsDisposable = mAnalytics.eventStream()
//                .filter(this::acceptEvent)
////                .doOnNext(this::logEvent)
//                .map(this::transformEvent)
//                .subscribeWith(new DisposableObserver<E>() {
//                    @Override
//                    public void onNext(E event) {
//                        postEvent(event);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        // log the error
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

    private void logEvent(@NonNull Event event) {

    }


    /*
     * Abstract methods
     */

    abstract boolean acceptEvent(@NonNull Event event);

    @NonNull
    abstract E transformEvent(@NonNull Event event);

    abstract void postEvent(@NonNull E event);





}
