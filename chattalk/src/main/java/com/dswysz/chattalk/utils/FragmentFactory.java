package com.dswysz.chattalk.utils;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.dswysz.chattalk.ui.ContactListFragment;
import com.dswysz.chattalk.ui.ConversateionListFragment;
import com.dswysz.chattalk.ui.SettingFragment;

/**
 * Create by h4de5ing 2016/5/12 012
 */
public class FragmentFactory {
    private static SparseArray<Fragment> map = new SparseArray<Fragment>();

    public static Fragment getFragment(int position) {
        Fragment fragment = null;
        if (map.get(position) != null) {
            fragment = map.get(position);
        }
        switch (position) {
            case 0:
                //会话列表
                fragment = new ConversateionListFragment();
                break;
            case 1:
                //联系人列表
                fragment = new ContactListFragment();
                break;
            case 2:
                fragment = new SettingFragment();
                break;
        }
        map.put(position, fragment);
        return fragment;
    }



}
