package com.example.yuejz.festec;

import android.app.Application;

import com.example.latte.ec.database.DataBaseManager;
import com.example.latte.ec.iocn.FontEcModule;
import com.example.latte_core.app.Latte;
import com.example.latte_core.net.interceptors.DebugInterceptor;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .configure();

        DataBaseManager.getInstance().init(this);
        initStetho();
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


