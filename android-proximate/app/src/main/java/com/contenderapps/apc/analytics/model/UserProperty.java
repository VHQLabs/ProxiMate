package com.contenderapps.apc.analytics.model;


import android.support.annotation.NonNull;

public class UserProperty {

    @NonNull
    public final String key;

    public final Object value;


    public UserProperty(@NonNull String name, Object property) {
        this.key = name;
        this.value = property;
    }
}
