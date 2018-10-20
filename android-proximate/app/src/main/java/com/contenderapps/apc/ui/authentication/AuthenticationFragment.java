package com.contenderapps.apc.ui.authentication;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contenderapps.apc.R;
import com.contenderapps.apc.routing.Navigator;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dm7.barcodescanner.zxing.ZXingScannerView;



public class AuthenticationFragment extends BaseMvpFragment<AuthenticationMvpView, AuthenticationPresenter> implements AuthenticationMvpView, ZXingScannerView.ResultHandler {

    private static final String TAG = AuthenticationFragment.class.getSimpleName();
    public static final int CAMERA_REQUEST_CODE = 1990;

    private ActivatedInterface mActivated;

    @BindView(R.id.qr_code_scanner)
    ZXingScannerView qrCodeScanner;


    public static AuthenticationFragment newInstance() {
        AuthenticationFragment fragment = new AuthenticationFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivated = (ActivatedInterface) this.getActivity();
    }

    @Override
    protected AuthenticationMvpView getThis() {
        return this;
    }

    @Override
    protected AuthenticationPresenter instantiatePresenter() {
        return new AuthenticationPresenter();
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authentication, container, false);
        mUnbinder =  ButterKnife.bind(this, view);

        initScanner();
        return view;
    }

    @Override
    public void showLoading() {

    }


    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(@StringRes int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void hideSoftKeyboard() {

    }

    @Override
    public void isAttached() {

    }


    @Override
    public void onResume() {
        super.onResume();

        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
        } else {

        }


        qrCodeScanner.startCamera();
        // TODO: 20/10/2018 set the hander for resulsts
        qrCodeScanner.setResultHandler(this);
//        qrCodeScanner.setResultHandler(this);
    }




    @Override
    public void onPause() {
        super.onPause();
        qrCodeScanner.stopCamera();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private void initScanner() {
        List<BarcodeFormat> formats = new ArrayList<>();
        formats.add(BarcodeFormat.QR_CODE);
        qrCodeScanner.setFormats(formats);
        qrCodeScanner.setAutoFocus(true);
        qrCodeScanner.setLaserColor(R.color.colorAccent);
        qrCodeScanner.setMaskColor(R.color.colorAccent);
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  Zerbra Crossing
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void handleResult(Result result) {
        Log.d(TAG, "handleResult: " + result);

        if (mActivated.isActivated()) { // it is already activated then we jump to the qr image
            mActivated.changeToQRFragment();
        } else {
            // we finish the flow of authentication
            Navigator.navigateToTransactions(mContext);
        }
        // TODO: 20/10/2018 move to the next activity




    }


















}
