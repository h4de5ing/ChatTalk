package com.dswysz.chattalk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hyphenate.chat.EMConversation;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseConversationListFragment;

/**
 * Create by h4de5ing 2016/5/13 013
 * 会话列表
 */
public class ConversateionListFragment extends EaseConversationListFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setConversationListItemClickListener(new EaseConversationListItemClickListener() {
            @Override
            public void onListItemClicked(EMConversation emConversation) {
                startActivity(new Intent(getActivity(), ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, emConversation.getUserName()));
            }
        });
    }
}
