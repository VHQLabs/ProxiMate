package com.contenderapps.apc.ui.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.contenderapps.apc.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MainActivity extends AppCompatActivity implements MainMenuInterface {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Fragment mFragmentRequests;
    private Fragment mFragmentMap;
    private Fragment mFragmentChat;
    private Fragment mFragmentUser;

    private Unbinder mUnbinder;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mUnbinder = ButterKnife.bind(this);

        mFragmentRequests = RequestsFragment.newInstance();
        mFragmentMap = MapFragment.newInstance();
        mFragmentChat = ChatFragment.newInstance();
        mFragmentUser = UserFragment.newInstance();

        if (savedInstanceState == null) {
            replaceFragment(mFragmentChat);
        }
    }



    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }







    @OnClick(R.id.user_btn)
    public void onUserClicked() {
        showUser();
    }

    @OnClick(R.id.requests_btn)
    public void onRequestsClicked() {
        showRequests();
    }
    @OnClick(R.id.map_btn)
    public void onMapClicked() {
        showMap();
    }
    @OnClick(R.id.chat_btn)
    public void onChatClicked() {
        showChat();
    }










    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  Main Menu Interface - bottom buttons
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void showMap() {
        replaceFragment(mFragmentMap);
    }

    @Override
    public void showChat() {
        replaceFragment(mFragmentChat);
    }

    @Override
    public void showRequests() {
        replaceFragment(mFragmentRequests);
    }

    @Override
    public void showUser() {
        replaceFragment(mFragmentUser);
    }
}
