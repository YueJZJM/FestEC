package com.example.latte_core.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.example.latte_core.delegates.web.event.Event;
import com.example.latte_core.delegates.web.event.EventManager;

/**
 * 与原生交互
 */
public final class LatteWebInterface {
    private final WebDelegate DELEGATE;

    public LatteWebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static LatteWebInterface create(WebDelegate delegate){
        return new LatteWebInterface(delegate);
    }

    @JavascriptInterface
    public String event(String params){
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(params);
            return event.execute(params);
        }
        return null;
    }
}
