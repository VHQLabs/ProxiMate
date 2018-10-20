package com.contenderapps.apc.analytics.trackers;

import android.content.Context;
import android.support.annotation.NonNull;

import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.analytics.model.Event;
import com.contenderapps.apc.injection.qualifiers.ApplicationContext;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;


/**
 *
 */

@Singleton
public class FabricAnswersTracker extends AbstractTracker<CustomEvent> {

    private static final String TAG = FabricAnswersTracker.class.getSimpleName();

    private Answers mAnswers;



    @Inject
    public FabricAnswersTracker(@ApplicationContext Context context, Analytics analytics) {
        super(context, analytics);
        mAnswers = Answers.getInstance();
    }

    @Override
    protected boolean isInterestedInEvents() {
        return false;
    }

    @Override
    protected boolean isInterestedInUserProperties() {
        return false;
    }

    @Override
    boolean acceptEvent(@Nonnull Event event) {
        return false;
    }






    @NonNull
    @Override
    CustomEvent transformEvent(@NonNull Event event) {
        CustomEvent customEvent = new CustomEvent(event.name);
        if (event.params != null) {
            for (String eventName : event.params.keySet()) {
                customEvent.putCustomAttribute(eventName, event.params.get(eventName));
            }
        }
        return customEvent;
    }

    @Override
    void postEvent(@NonNull CustomEvent event) {
        mAnswers.logCustom(event);
    }

}
