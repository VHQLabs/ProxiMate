package com.contenderapps.apc.ui.chat;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.contenderapps.apc.R;
import com.contenderapps.apc.data.chat.Message;
import com.contenderapps.apc.data.fixtures.MessagesFixtures;
import com.contenderapps.apc.ui.base.fragments.BaseMvpFragment;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.util.Date;


public class ChatFragment extends BaseMvpFragment<ChatMvpView, ChatPresenter> implements ChatMvpView,
    MessageInput.InputListener,
    MessageInput.AttachmentsListener
{

    private static final String TAG = ChatFragment.class.getSimpleName();

    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }

    private static final int TOTAL_MESSAGES_COUNT = 100;

    protected final String senderId = "0";
    protected ImageLoader imageLoader;
    protected MessagesListAdapter<Message> messagesAdapter;

    private Menu menu;
    private int selectionCount;
    private Date lastLoadedDate;

    private MessagesList messagesList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url, Object payload) {
                Picasso.with(getActivity()).load(url).into(imageView);
            }
        };
    }

    @Override
    protected ChatMvpView getThis() {
        return this;
    }

    @Override
    protected ChatPresenter instantiatePresenter() {
        return new ChatPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        this.messagesList = (MessagesList) view.findViewById(R.id.messagesList);
        initAdapter();

        MessageInput input = (MessageInput) view.findViewById(R.id.input);
        input.setInputListener(this);
        input.setAttachmentsListener(this);

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
//        mPresenter.loadData();
    }

    @Override
    public void onStart() {
        super.onStart();
        messagesAdapter.addToStart(new Message(MessagesFixtures.getRandomId(), MessagesFixtures.getUser(0), "I want you to receive for me \"Striped Hudson Jeans Shorts\" from Mercari. " +
                "Expected on Monday, October 22"), true);
        Message message = new Message(MessagesFixtures.getRandomId(), MessagesFixtures.getUser(0), "");
        message.setImage(new Message.Image(MessagesFixtures.getImage(0)));
        messagesAdapter.addToStart(message, true);
        messagesAdapter.addToStart(new Message(MessagesFixtures.getRandomId(), MessagesFixtures.getUser(1), "Ready to receive it for you. My address Nagodziców 18-54."), true);

//            messagesAdapter.addToStart(MessagesFixtures.getTextMessage(), true);
    }

    @Override
    public boolean onSubmit(CharSequence input) {
        Message message = new Message(MessagesFixtures.getRandomId(), MessagesFixtures.getUser(0), input.toString());
        messagesAdapter.addToStart(message, true);

        new Handler().postDelayed(new Runnable() { //imitation of internet connection
            @Override
            public void run() {
                messagesAdapter.addToStart(new Message(MessagesFixtures.getRandomId(), MessagesFixtures.getUser(1), "Great. I'll write to you when receive it"), true);

            }
        }, 2000);


        new Handler().postDelayed(new Runnable() { //imitation of internet connection
            @Override
            public void run() {
                messagesAdapter.addToStart(new Message(MessagesFixtures.getRandomId(), MessagesFixtures.getUser(1), "Received your package"), true);

            }
        }, 30000);

        return true;
    }


    @Override
    public void onAddAttachments() {
//        new AlertDialog.Builder(this)
//                .setItems(R.array.view_types_dialog, this)
//                .show();
    }

    private void initAdapter() {
        messagesAdapter = new MessagesListAdapter<>(senderId, imageLoader);
//        messagesAdapter.enableSelectionMode(this);
//        messagesAdapter.setLoadMoreListener(this);
//        messagesAdapter.registerViewClickListener(R.id.messageUserAvatar,
//                new MessagesListAdapter.OnMessageViewClickListener<Message>() {
//                    @Override
//                    public void onMessageViewClick(View view, Message message) {
//                        AppUtils.showToast(DefaultMessagesActivity.this,
//                                message.getUser().getName() + " avatar click",
//                                false);
//                    }
//                });
        this.messagesList.setAdapter(messagesAdapter);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                  ButterKnife
    ////////////////////////////////////////////////////////////////////////////////////////////////





}
