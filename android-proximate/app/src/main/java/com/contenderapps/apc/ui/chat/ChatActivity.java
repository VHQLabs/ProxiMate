package com.contenderapps.apc.ui.chat;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.contenderapps.apc.data.chat.Message;
import com.contenderapps.apc.ui.base.activities.BaseToolbarActivity;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.text.SimpleDateFormat;
import java.util.Locale;
//import com.stfalcon.chatkit.sample.R;
//import com.stfalcon.chatkit.sample.common.data.fixtures.MessagesFixtures;
//import com.stfalcon.chatkit.sample.common.data.model.Message;
//import com.stfalcon.chatkit.sample.utils.AppUtils;


public class ChatActivity extends BaseToolbarActivity
{
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setToolbarTitle("Chat");

            if (savedInstanceState == null) {
                replaceFragment(ChatFragment.newInstance());
            }
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

//        @Override
//        public void onBackPressed() {
//            if (selectionCount == 0) {
//                super.onBackPressed();
//            } else {
//                messagesAdapter.unselectAllItems();
//            }
//        }


//        @Override
//        public void onSelectionChanged(int count) {
//            this.selectionCount = count;
//            menu.findItem(R.id.action_delete).setVisible(count > 0);
//            menu.findItem(R.id.action_copy).setVisible(count > 0);
//        }

//        protected void loadMessages() {
//            new Handler().postDelayed(new Runnable() { //imitation of internet connection
//                @Override
//                public void run() {
//                    ArrayList<Message> messages = MessagesFixtures.getMessages(lastLoadedDate);
//                    lastLoadedDate = messages.get(messages.size() - 1).getCreatedAt();
//                    messagesAdapter.addToEnd(messages, false);
//                }
//            }, 1000);
//        }

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
//            replaceFragment(DeliveryFragment.newInstance());
//        }
//    }
}
