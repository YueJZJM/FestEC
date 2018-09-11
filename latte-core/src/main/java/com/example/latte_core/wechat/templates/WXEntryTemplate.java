package com.example.latte_core.wechat.templates;

import com.example.latte_core.activities.ProxyActivity;
import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.wechat.LatteWeChat;

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }


}
