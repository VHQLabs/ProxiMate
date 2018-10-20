package com.contenderapps.apc.ui.base.fragments;

import com.contenderapps.apc.ui.base.presenters.PresenterManager;

import javax.inject.Inject;

/**
 * This class gets injected with PresenterManager by the injection framework (dagger 2).
 */
public class BaseMvpFragmentInjector {


    @Inject
    PresenterManager mPresenterManager;

}
