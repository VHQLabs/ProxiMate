package com.contenderapps.apc.injection.components;

import com.contenderapps.apc.injection.scopes.PerPresenter;
import com.contenderapps.apc.ui.authentication.AuthenticationPresenter;
import com.contenderapps.apc.ui.chat.ChatPresenter;
import com.contenderapps.apc.ui.create.CreatePresenter;
import com.contenderapps.apc.ui.deliverydetails.DeliveryActivity;
import com.contenderapps.apc.ui.deliverydetails.DeliveryPresenter;
import com.contenderapps.apc.ui.home.HomePresenter;
import com.contenderapps.apc.ui.splash.SplashPresenter;
import com.contenderapps.apc.ui.main.MainPresenter;

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

    void inject(MainPresenter presenter);

    void inject(ChatPresenter presenter);

    void inject(CreatePresenter presenter);

    void inject(DeliveryPresenter presenter);

}
