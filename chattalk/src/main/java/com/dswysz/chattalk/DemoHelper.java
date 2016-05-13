package com.dswysz.chattalk;

import android.content.Context;

import com.dswysz.chattalk.utils.PreferenceManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;

/**
 * Create by h4de5ing 2016/5/12 012
 */
public class DemoHelper {


    private static DemoHelper instance = null;
    private DemoModel demoModel = null;
    private String username;
    private Context appContext;
    private EaseUI easeUI;

    /**
     * init helper
     *
     * @param context application context
     */
    public void init(Context context) {
        demoModel = new DemoModel(context);
        EMOptions options = initChatOptions();
        //options传null则使用默认的
        if (EaseUI.getInstance().init(context, options)) {
            appContext = context;
            EMClient.getInstance().setDebugMode(true); //设为调试模式，打成正式包时，最好设为false，以免消耗额外的资源
            //get easeui instance
            easeUI = EaseUI.getInstance();
            //调用easeui的api设置providers   设置用户头像和昵称
            //setEaseUIProviders();
            //初始化PreferenceManager
            PreferenceManager.init(context);
            //初始化用户管理类
            //getUserProfileManager().init(context);

            //设置全局监听
            //setGlobalListeners();
            //broadcastManager = LocalBroadcastManager.getInstance(appContext);
            //initDbDao();


        }
    }

    public synchronized static DemoHelper getInstance() {
        if (instance == null) {
            instance = new DemoHelper();
        }
        return instance;
    }

    private EMOptions initChatOptions() {
        EMOptions options = new EMOptions();// 获取到EMChatOptions对象
        options.setAcceptInvitationAlways(true);// 默认添加好友时，是不需要验证的，改成需要验证
        options.setRequireAck(true);// 设置是否需要已读回执
        options.setRequireDeliveryAck(false);// 设置是否需要已送达回执

        //使用gcm和mipush时，把里面的参数替换成自己app申请的
        //设置google推送，需要的GCM的app可以设置此参数
        options.setGCMNumber("324169311137");
        //在小米手机上当app被kill时使用小米推送进行消息提示，同GCM一样不是必须的
        options.setMipushConfig("2882303761517426801", "5381742660801");
        //集成华为推送时需要设置
        //  options.setHuaweiPushAppId("10492024");

        //options.allowChatroomOwnerLeave(getModel().isChatroomOwnerLeaveAllowed());
        // options.setDeleteMessagesAsExitGroup(getModel().isDeleteMessagesAsExitGroup());
        // options.setAutoAcceptGroupInvitation(getModel().isAutoAcceptGroupInvitation());

        return options;
    }

    /**
     * 是否登录成功过
     */

    public boolean isLoggedIn() {
        return EMClient.getInstance().isLoggedInBefore();
    }

    /**
     * 设置当前用户的环信id
     */
    public void setCurrentUserName(String username) {
        this.username = username;
        demoModel.setCurrentUserName(username);
    }

    /**
     * 获取当前用户的环信id
     */
    public String getCurrentUsernName() {
        if (username == null) {
            username = demoModel.getCurrentUsernName();
        }
        return username;
    }
}
