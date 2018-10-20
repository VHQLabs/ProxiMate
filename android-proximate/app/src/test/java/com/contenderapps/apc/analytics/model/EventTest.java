package com.contenderapps.apc.analytics.model;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;



/**
 *
 *
 */
public class EventTest {


    @Test
    public void testObjectCreation() {
        String eventName = "click";
        Event analyticsEvent = new Event(eventName, null);
        assertEquals(analyticsEvent.name, eventName);

        Map parameters = new HashMap();
        analyticsEvent = new Event(eventName, parameters);
        assertEquals(analyticsEvent.params, parameters);
    }


}
