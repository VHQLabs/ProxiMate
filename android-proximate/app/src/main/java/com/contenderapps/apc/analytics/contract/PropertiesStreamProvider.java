package com.contenderapps.apc.analytics.contract;


import android.support.annotation.NonNull;

import com.contenderapps.apc.analytics.model.UserProperty;

import io.reactivex.Observable;


public interface PropertiesStreamProvider {

    @NonNull
    Observable<UserProperty> propertyStream();

}
