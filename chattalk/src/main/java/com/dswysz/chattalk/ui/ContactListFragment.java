package com.dswysz.chattalk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by h4de5ing 2016/5/13 013
 */
public class ContactListFragment extends EaseContactListFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContactsMap(getContacts());
        this.setContactListItemClickListener(new EaseContactListItemClickListener() {
            @Override
            public void onListItemClicked(EaseUser user) {
                startActivity(new Intent(getActivity(), ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, user.getUsername()));
            }
        });
    }

    /**
     * 临时生成的数据，密码皆为123456，可以登录测试接发消息
     *
     * @return
     */
    private static Map<String, EaseUser> getContacts() {
        Map<String, EaseUser> contacts = new HashMap<String, EaseUser>();
        for (int i = 1; i <= 10; i++) {
            EaseUser user = new EaseUser("Talk-" + i);
            contacts.put("Talk-" + i, user);
        }
        return contacts;
    }
}
