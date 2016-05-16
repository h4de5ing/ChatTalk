package com.dswysz.chattalk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.dswysz.chattalk.R;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseBaseActivity;
import com.hyphenate.easeui.ui.EaseChatFragment;

import java.util.List;

/**
 * Create by h4de5ing 2016/5/13 013
 */
public class ChatActivity extends EaseBaseActivity {
    public static ChatActivity activityInstance;
    private EaseChatFragment chatFragment;
    String toChatUsername;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_chat);
        activityInstance = this;
        //聊天人或群id
        toChatUsername = getIntent().getExtras().getString(EaseConstant.EXTRA_USER_ID);
        chatFragment = new EaseChatFragment();
        //传入参数
        chatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityInstance = null;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // 点击notification bar进入聊天页面，保证只有一个聊天页面
        String username = intent.getStringExtra("userId");
        if (toChatUsername.equals(username))
            super.onNewIntent(intent);
        else {
            finish();
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        chatFragment.onBackPressed();
        EMConversation conversation = EMClient.getInstance().chatManager().getConversation(toChatUsername);
        List<EMMessage> allMessages = conversation.getAllMessages();
        EMClient.getInstance().chatManager().importMessages(allMessages);
        Toast.makeText(ChatActivity.this, "消息已经存入数据库中了..", Toast.LENGTH_SHORT).show();
    }

    public String getToChatUsername() {
        return toChatUsername;
    }
}
