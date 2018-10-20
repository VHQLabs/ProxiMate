package com.contenderapps.apc.ui.chat;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.contenderapps.apc.R;
import com.contenderapps.apc.data.chat.Message;
import com.contenderapps.apc.data.chat.User;
import com.contenderapps.apc.data.fixtures.MessagesFixtures;
import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.messages.MessageHolders;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.messages.MessagesListAdapter;
//import com.stfalcon.chatkit.sample.R;
//import com.stfalcon.chatkit.sample.common.data.fixtures.MessagesFixtures;
//import com.stfalcon.chatkit.sample.common.data.model.Message;
//import com.stfalcon.chatkit.sample.utils.AppUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class ChatActivity extends BaseToolbarActivity
        implements
// MessagesListAdapter.SelectionListener,
    MessagesListAdapter.OnLoadMoreListener,
        MessageInput.InputListener,
        MessageInput.AttachmentsListener
{

        private static final int TOTAL_MESSAGES_COUNT = 100;

        protected final String senderId = "0";
        protected ImageLoader imageLoader;
        protected MessagesListAdapter<Message> messagesAdapter;

        private Menu menu;
        private int selectionCount;
        private Date lastLoadedDate;

        private MessagesList messagesList;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setToolbarTitle("Chat");

//            if (savedInstanceState == null) {
//                replaceFragment(HomeFragment.newInstance());
//            }


            imageLoader = new ImageLoader() {
                @Override
                public void loadImage(ImageView imageView, String url, Object payload) {
                    Picasso.with(ChatActivity.this).load(url).into(imageView);
                }
            };

            setContentView(R.layout.activity_chat);

            this.messagesList = (MessagesList) findViewById(R.id.messagesList);
            initAdapter();

            MessageInput input = (MessageInput) findViewById(R.id.input);
            input.setInputListener(this);
//            input.setTypingListener(this);
            input.setAttachmentsListener(this);

        }

        @Override
        protected void onStart() {
            super.onStart();
            messagesAdapter.addToStart(new Message(MessagesFixtures.getRandomId(), MessagesFixtures.getUser(0), "I want you to receive for me \"Striped Hudson Jeans Shorts\" from Mercari. " +
                    "Expected on Monday, October 22"), true);
            messagesAdapter.addToStart(new Message(MessagesFixtures.getRandomId(), MessagesFixtures.getUser(1), "Ready to receive it for you. My address Nagodziców 18-54."), true);

//            messagesAdapter.addToStart(MessagesFixtures.getTextMessage(), true);
        }

//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            this.menu = menu;
//            getMenuInflater().inflate(R.menu.chat_actions_menu, menu);
//            onSelectionChanged(0);
//            return true;
//        }

//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.action_delete:
//                    messagesAdapter.deleteSelectedMessages();
//                    break;
//                case R.id.action_copy:
//                    messagesAdapter.copySelectedMessagesText(this, getMessageStringFormatter(), true);
//                    AppUtils.showToast(this, R.string.copied_message, true);
//                    break;
//            }
//            return true;
//        }

        @Override
        public void onBackPressed() {
            if (selectionCount == 0) {
                super.onBackPressed();
            } else {
                messagesAdapter.unselectAllItems();
            }
        }

        @Override
        public void onLoadMore(int page, int totalItemsCount) {
            Log.i("TAG", "onLoadMore: " + page + " " + totalItemsCount);
//            if (totalItemsCount < TOTAL_MESSAGES_COUNT) {
//                loadMessages();
//            }
        }

//        @Override
//        public void onSelectionChanged(int count) {
//            this.selectionCount = count;
//            menu.findItem(R.id.action_delete).setVisible(count > 0);
//            menu.findItem(R.id.action_copy).setVisible(count > 0);
//        }

        protected void loadMessages() {
            new Handler().postDelayed(new Runnable() { //imitation of internet connection
                @Override
                public void run() {
                    ArrayList<Message> messages = MessagesFixtures.getMessages(lastLoadedDate);
                    lastLoadedDate = messages.get(messages.size() - 1).getCreatedAt();
                    messagesAdapter.addToEnd(messages, false);
                }
            }, 1000);
        }

        private MessagesListAdapter.Formatter<Message> getMessageStringFormatter() {
            return new MessagesListAdapter.Formatter<Message>() {
                @Override
                public String format(Message message) {
                    String createdAt = new SimpleDateFormat("MMM d, EEE 'at' h:mm a", Locale.getDefault())
                            .format(message.getCreatedAt());

                    String text = message.getText();
                    if (text == null) text = "[attachment]";

                    return String.format(Locale.getDefault(), "%s: %s (%s)",
                            message.getUser().getName(), text, createdAt);
                }
            };
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
        }, 10000);

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
        messagesAdapter.setLoadMoreListener(this);
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

    private static final String TAG = ChatActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        return intent;
    }
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setToolbarTitle("Chat");
//
//        if (savedInstanceState == null) {
//            replaceFragment(HomeFragment.newInstance());
//        }
//    }
}
