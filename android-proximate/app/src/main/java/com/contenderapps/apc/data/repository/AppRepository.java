package com.contenderapps.apc.data.repository;


import com.contenderapps.apc.data.datasource.PreferencesDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppRepository {

    private static final String TAG = AppRepository.class.getSimpleName();

    private PreferencesDataSource mPreferencesDataSource;

    @Inject
    public AppRepository(PreferencesDataSource preferencesDataSource) {
        mPreferencesDataSource = preferencesDataSource;
    }








}
