package com.dswysz.chattalk;

import android.content.Context;

import com.dswysz.chattalk.utils.PreferenceManager;

/**
 * Create by h4de5ing 2016/5/12 012
 */
public class DemoModel {
    protected Context context = null;

    public DemoModel(Context ctx) {
        context = ctx;
        PreferenceManager.init(context);
    }

    /**
     * 设置当前用户的环信id
     *
     */
    public void setCurrentUserName(String username) {
        PreferenceManager.getInstance().setCurrentUserName(username);
    }

    /**
     * 获取当前用户的环信id
     */
    public String getCurrentUsernName() {
        return PreferenceManager.getInstance().getCurrentUsername();
    }
}
