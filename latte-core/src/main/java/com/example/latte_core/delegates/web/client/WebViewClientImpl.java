package com.example.latte_core.delegates.web.client;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte_core.delegates.web.WebDelegate;
import com.example.latte_core.delegates.web.route.Router;

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;

    public WebViewClientImpl(WebDelegate delegate){
        this.DELEGATE = delegate;
    }

    //返回true。表示页面的跳转，以及重定向，都由原生接管
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return Router.getInstance().handleWebUrl(DELEGATE, url);
    }
}
