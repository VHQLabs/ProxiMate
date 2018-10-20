package com.contenderapps.apc.analytics.contract;


import com.contenderapps.apc.analytics.model.Event;
import javax.annotation.Nonnull;

import io.reactivex.Observable;

public interface EventsStreamProvider {

    @Nonnull
    Observable<Event> eventStream();

}
