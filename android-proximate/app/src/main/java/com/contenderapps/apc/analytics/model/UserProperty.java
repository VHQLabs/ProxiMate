package com.contenderapps.apc.analytics.model;


import android.support.annotation.NonNull;

import com.contenderapps.apc.utils.AppConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserProperty {


    @NonNull
    public final String key;

    public final String name;
    public final String lastName;

    public final String address;



    public UserProperty(@NonNull String uuid, String name, String lastName, String address) {
        this.key = uuid;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }



    public String getUserProperties() {
        List<String> fields = new ArrayList<>();
        fields.add(key);
        fields.add(name);
        fields.add(lastName);
        fields.add(address);

        StringBuilder stringBuilder = new StringBuilder(100);
        for (String field : fields) {
            stringBuilder.append(field);
            stringBuilder.append(AppConstants.QR_FIELDS_SEPARATOR);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1); // remove the last separator
        return stringBuilder.toString();
    }







}
