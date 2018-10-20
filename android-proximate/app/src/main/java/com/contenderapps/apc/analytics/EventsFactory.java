package com.contenderapps.apc.analytics;

import com.contenderapps.apc.analytics.model.Event;

/**
 * Created by adam on 8/27/17.
 * The solution here is to use factory methods in order to create the events.
 * The idea would be to offer a static factory method for each event we want to track,
 * rather than creating them directly through the Event constructor.
 */
public class EventsFactory {


    public static Event shareApplication() {
        Event event = new Event(EventNames.EVENT_NAME_SHARE_APPLICATION, null);
        return event;
    }

    public static Event rateApplication() {
        Event event = new Event(EventNames.EVENT_NAME_RATE_APPLICATION, null);
        return event;
    }



}
