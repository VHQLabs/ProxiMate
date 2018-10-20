package com.contenderapps.apc.ui.base.presenters;



public interface Presenter<V extends MvpView> {

    void activityCreated(boolean isFirstTime, V view);

    void viewAttached();

    void viewDetached();

}
