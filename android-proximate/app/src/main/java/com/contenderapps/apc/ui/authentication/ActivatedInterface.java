package com.contenderapps.apc.ui.authentication;

public interface ActivatedInterface {

    public boolean isActivated();

    public void setQRString(String qr);

    public String getQRString();

    void changeToQRFragment();

}
