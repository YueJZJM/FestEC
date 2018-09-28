package com.example.latte_core.delegates.web.event;

import android.webkit.WebView;
import android.widget.Toast;

public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(),getAction(),Toast.LENGTH_SHORT).show();
        if (getAction().equals("test")) {
            final WebView webView = getWewView();
            getWewView().post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall();",null);
                }
            });
        }
        return null;
    }
}
