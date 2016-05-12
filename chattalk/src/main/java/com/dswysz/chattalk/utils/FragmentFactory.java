package com.dswysz.chattalk.utils;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

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
                break;
            //fragment = new EaseChatFragment();
            case 1:
                break;
            case 2:
                break;
            //map.put(fragment);
        }
        return fragment;
    }
}
