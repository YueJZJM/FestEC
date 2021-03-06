package com.example.latte_core.delegates.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte_core.delegates.IPageLoadListener;
import com.example.latte_core.delegates.web.chromeclient.WebChromeClientImpl;
import com.example.latte_core.delegates.web.client.WebViewClientImpl;
import com.example.latte_core.delegates.web.route.RouteKeys;
import com.example.latte_core.delegates.web.route.Router;

public class WebDelegateImpl extends WebDelegate implements IWebViewInitializer{

    private IPageLoadListener mIPageLoadListener;

    public static WebDelegateImpl create(String url){
        final Bundle args = new Bundle();
        args.putString(RouteKeys.URL.name(),url);
        final WebDelegateImpl delegate = new WebDelegateImpl();
        delegate.setArguments(args);
        return delegate;
    }

    public void setIPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }

    @Override
    public IWebViewInitializer setInitializer() {
        return this;
    }

    @Override
    public Object setLayout() {
        return getWebView();
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        if (getUrl() != null){
            //用原生的方式模拟web并跳转页面加载
            Router.getInstance().loadPage(this,getUrl());
        }
    }


    @Override
    public WebView initWebView(WebView webView) {
        return new WebViewInitializer().createWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClient() {
        final WebViewClientImpl client = new WebViewClientImpl(this);
        client.setIPageLoadListener(mIPageLoadListener);
        return client;
    }

    @Override
    public WebChromeClient initWebChromeClient() {
        return new WebChromeClientImpl();
    }
}
