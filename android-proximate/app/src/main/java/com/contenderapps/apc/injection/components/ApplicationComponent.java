package com.contenderapps.apc.injection.components;


import android.content.Context;

import com.contenderapps.apc.CustomApplication;
import com.contenderapps.apc.analytics.Analytics;
import com.contenderapps.apc.data.repository.AppRepository;
import com.contenderapps.apc.injection.modules.ApplicationModule;
import com.contenderapps.apc.injection.modules.DataModule;
import com.contenderapps.apc.injection.qualifiers.ApplicationContext;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragmentInjector;
import javax.inject.Singleton;
import dagger.Component;


/**
 * This annotation is used to build interface which wires everything together.
 * In this place we define from which modules (or other Components) we’re taking dependencies.
 * Also here is the place to define which graph dependencies should be visible
 * publicly (can be injected) and where our component can inject objects.
 * @Component in general is a something like bridge between @Module and @Inject.
 *
 * This is the part that does most of the basis wiring.
 * A module provides dependencies.
 * A component binds those dependencies to the fields with @Inject annotation
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DataModule.class
        }
)
public interface ApplicationComponent {

    void inject(BaseMvpFragmentInjector baseMvpFragmentInjector);

    void inject(CustomApplication customApplication);


    @ApplicationContext
    Context context();

    CustomApplication application();

    Analytics analytics();

    AppRepository appRepository();

}
