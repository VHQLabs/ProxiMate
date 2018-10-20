package com.contenderapps.apc.injection.components;

import com.contenderapps.apc.injection.scopes.PerPresenter;
import com.contenderapps.apc.ui.authentication.AuthenticationPresenter;
import com.contenderapps.apc.ui.home.HomePresenter;
import com.contenderapps.apc.ui.splash.SplashPresenter;

import dagger.Component;

/**
 * Injects dependencies to all MvpFragments across the application
 */
@PerPresenter
@Component(
        dependencies = {
                ApplicationComponent.class
        }
)
public interface PresenterComponent {

    void inject(SplashPresenter presenter);

    void inject(HomePresenter presenter);

    void inject(AuthenticationPresenter presenter);


}
