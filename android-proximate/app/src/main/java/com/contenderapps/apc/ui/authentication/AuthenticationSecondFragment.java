package com.contenderapps.apc.ui.authentication;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.contenderapps.apc.R;
import com.contenderapps.apc.analytics.model.UserProperty;
import com.contenderapps.apc.glide.ImageGlide;
import com.contenderapps.apc.routing.Navigator;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;
import com.contenderapps.apc.utils.QRUtils;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AuthenticationSecondFragment extends BaseMvpFragment<AuthenticationMvpView, AuthenticationPresenter> implements AuthenticationMvpView {

    private static final String TAG = AuthenticationSecondFragment.class.getSimpleName();

    private QRUtils qrGenerator;

    private ActivatedInterface mActivated;

    @BindView(R.id.qr_image)
    ImageView mQRImage;

    @BindView(R.id.finish_tv)
    TextView mFinish;

    public static AuthenticationSecondFragment newInstance() {
        AuthenticationSecondFragment fragment = new AuthenticationSecondFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qrGenerator = QRUtils.newInstance(mContext);
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
        View view = inflater.inflate(R.layout.fragment_authentication_generate_qr, container, false);
        mUnbinder =  ButterKnife.bind(this, view);


        // todo: change the identity of the person for each phone


        UserProperty up = new UserProperty(
                UUID.randomUUID().toString(),
                "Adam",
                "Ingegneri",
                "Corso Belfiore 15"
        );
        String content = up.getUserProperties();

        Bitmap qrImage = qrGenerator
                .setErrorCorrectionLevel(ErrorCorrectionLevel.Q)
                .setContent(content)
                .getQRCOde();

        ImageGlide.with(mQRImage)
                .load(qrImage)
                .placeholder(new ColorDrawable(Color.WHITE))
                .into(mQRImage);


        if (!mActivated.isActivated()) {
            mFinish.setText("Next");
        }

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
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @OnClick(R.id.finish_tv)
    public void onFinishClicked() {

        if (mActivated.isActivated()) {
            Navigator.navigateToTransactions(mContext);
        } else {
            mActivated.changeToCameraFragment();
            Toast.makeText(mContext, "Account Activated", Toast.LENGTH_LONG).show();
        }

    }














}
