package com.dswysz.chattalk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.exceptions.HyphenateException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by h4de5ing 2016/5/13 013
 * 联系人列表
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
        try {
            List<String> usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
            for (int i = 1; i <= usernames.size(); i++) {
                EaseUser user = new EaseUser(usernames.get(i));
                contacts.put(usernames.get(i), user);
            }
        } catch (HyphenateException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
