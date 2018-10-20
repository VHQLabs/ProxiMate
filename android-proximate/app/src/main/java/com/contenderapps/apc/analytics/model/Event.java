package com.contenderapps.apc.analytics.model;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Map;

public class Event {

    @NonNull
    public final String name;

    @Nullable
    public final Map<String, String> params;


    public Event(@NonNull String name, @Nullable Map<String, String> params) {
        this.name = name;
        this.params = params;
    }
}
