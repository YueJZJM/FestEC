package com.example.yuejz.festec;

import android.app.Application;

import com.example.latte.ec.database.DataBaseManager;
import com.example.latte.ec.iocn.FontEcModule;
import com.example.latte_core.app.Latte;
import com.example.latte_core.delegates.web.event.TestEvent;
import com.example.latte_core.net.interceptors.DebugInterceptor;
import com.example.latte_core.net.rx.AddCookieInterceptor;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.jpush.android.api.JPushInterface;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                //   .withApiHost("http://oxjde2kpq.bkt.clouddn.com/")
                .withApiHost("http://mock.fulingjie.com/mock/data/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                // .withWebEvent("action", new TestEvent())
                //      .withWeChatAppId("")
                //   .withWeChatAppSecret("")
                .withWebHost("https://www.baidu.com/")
                //添加cookie的拦截器
                .withInterceptor(new AddCookieInterceptor())
                .configure();

        DataBaseManager.getInstance().init(this);
        initStetho();

        //极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    private void initStetho(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }
}


