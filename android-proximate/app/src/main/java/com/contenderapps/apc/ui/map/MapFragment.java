package com.contenderapps.apc.ui.map;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.R;
import com.contenderapps.apc.routing.Navigator;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends com.google.android.gms.maps.SupportMapFragment
        implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private static final String TAG = MapFragment.class.getSimpleName();

    private boolean mIsActivated;

    private GoogleMap mMap;

//    @BindView(R.id.transactions_btn)
//    Button mTransactions;
//
//    @BindView(R.id.activate_btn)
//    Button mActivate;

    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        String model = Build.MODEL;
//        if (model.startsWith("DUK")) {
//            mPresenter.setActivated(true);
//            mIsActivated = true;
//        } else {
//            mPresenter.checkActivated();
//        }

        this.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(this);

        // Add a marker in Sydney and move the camera
        LatLng person1 = new LatLng(52.314239, 20.965203);
        LatLng person2 = new LatLng(52.315226, 20.965658);
        mMap.addMarker(new MarkerOptions().position(person1).title("Mok Oh"));
        mMap.addMarker(new MarkerOptions().position(person2).title("Robert K"));

        LatLng center = new LatLng((person1.latitude + person2.latitude) / 2, (person1.longitude + person2.longitude) / 2);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center,18));
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Navigator.navigateToChat(mContext);
    }

//    @Override
//    protected HomeMvpView getThis() {
//        return this;
//    }
//
//    @Override
//    protected HomePresenter instantiatePresenter() {
//        return new HomePresenter();
//    }




//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragmen, container, false);
//        mUnbinder = ButterKnife.bind(this, view);
//        return view;
//    }


//    @Override
//    public void showLoading() {
//
//    }
//
//    @Override
//    public void hideLoading() {
//
//    }
//
//    @Override
//    public void onError(@StringRes int resId) {
//
//    }
//
//    @Override
//    public void onError(String message) {
//
//    }
//
//    @Override
//    public void hideSoftKeyboard() {
//
//    }
//
//    @Override
//    public void isAttached() {
//
//    }


//    @Override
//    public void onResume() {
//        super.onResume();
////        mPresenter.loadData();
//    }




//    @OnClick(R.id.transactions_btn)
//    public void onTransactionsClick() {
//
//    }


//    @OnClick(R.id.activate_btn)
//    public void onActivateClick() {
//        //
//        Navigator.navigateToActivation(mContext, mIsActivated);
////        this.getActivity().finish();
//    }





    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    public void setActivated(boolean activated) {
//        mIsActivated = activated;
//    }


    // added value:
    // sei nel giro dell'applicazione
    // stai allargando la cerchia
    //
    // krok po kroku
    // the profile that has just been created won't receive valuable packages
    //
    // what else
    // when you sell something you get a lower fee when you sell
    //
    // social kupowania ?

    //



}
