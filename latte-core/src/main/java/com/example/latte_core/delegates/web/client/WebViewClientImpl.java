package com.example.latte_core.delegates.web.client;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte_core.app.ConfigKeys;
import com.example.latte_core.app.Latte;
import com.example.latte_core.delegates.IPageLoadListener;
import com.example.latte_core.delegates.web.WebDelegate;
import com.example.latte_core.delegates.web.route.Router;
import com.example.latte_core.ui.LatteLoader;
import com.example.latte_core.util.storeage.LattePreference;

import java.util.logging.Handler;

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;
    private IPageLoadListener mIPageLoadListener;
    private static final android.os.Handler HANDLER = Latte.getHandler();

    public void setIPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }

    public WebViewClientImpl(WebDelegate delegate){
        this.DELEGATE = delegate;
    }

    //返回true。表示页面的跳转，以及重定向，都由原生接管
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return Router.getInstance().handleWebUrl(DELEGATE, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    //获取浏览器的cookie
    private void syncCookie() {
        final CookieManager manager = CookieManager.getInstance();
        //这里的cookie和API请求的cookie是不一样的，这个在网页不可见
        final String webHost = Latte.getConfiguration(ConfigKeys.WEB_HOST);
        if (webHost != null) {
            final String cookieStr = manager.getCookie(webHost);
            if (!TextUtils.isEmpty(cookieStr)) {
                LattePreference.addCustomAppProfile("cookie",cookieStr);
            }

        }
       // final String cookieStr = manager.getCookie("https://www.baidu.com");
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        syncCookie();
            if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadEnd();
        }
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                LatteLoader.stopLoading();
            }
        }, 1000);
    }
}
