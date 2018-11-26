package com.example.yuejz.festec.event;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.latte_core.delegates.web.event.Event;
import com.mob.MobSDK;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class ShareEvent extends Event {
    @Override
    public String execute(String params) {

        Log.d("ShareEvent", "execute");
        final JSONObject object = JSON.parseObject(params).getJSONObject("params");
        final String title = object.getString("title");
        final String url = object.getString("url");
        final String imageUrl = object.getString("imageUrl");
        final String text = object.getString("text");


        MobSDK.init(getContext());

        final OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle(title);
        oks.setText(text);
        oks.setImageUrl(imageUrl);
        oks.setUrl(url);
        oks.show(getContext());

        return null;
    }
}
