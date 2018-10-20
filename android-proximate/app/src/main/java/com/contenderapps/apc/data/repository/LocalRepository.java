package com.contenderapps.apc.data.repository;

import com.contenderapps.apc.data.models.base.Example;

import io.reactivex.Flowable;

/**
 *
 *
 */
public interface LocalRepository {

    Flowable<Example> getExample();



}
