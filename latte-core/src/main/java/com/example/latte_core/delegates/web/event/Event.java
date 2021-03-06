package com.example.latte_core.delegates.web.event;

import android.content.Context;
import android.webkit.WebView;

import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.delegates.web.WebDelegate;

public abstract class Event implements IEvent{

    private Context mContext = null;
    private String mAction = null;
    private WebDelegate mDelegate = null;
    private String mUrl = null;
    private WebView mWewView = null;

    public Event() {
    }

    public Event(Context context, String cction, WebDelegate delegate, String url) {
        this.mContext = context;
        this.mAction = cction;
        this.mDelegate = delegate;
        this.mUrl = url;
    }

    public WebView getWewView() {
        return mDelegate.getWebView();
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        this.mAction = action;
    }

    public WebDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(WebDelegate delegate) {
        this.mDelegate = delegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }
}
