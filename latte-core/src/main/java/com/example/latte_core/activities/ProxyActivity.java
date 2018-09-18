package com.example.latte_core.activities;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.example.latte_core.R;
import com.example.latte_core.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

   // @SuppressLint("RestrictedApi")
    private void initContainer(@Nullable Bundle savedInstanceState) {

        //这个注解的意思就是告诉Android的Lint工具，下面的类或者方法是与一个指定的API相对应的，忽略manifeset文件里面的minSdk的设置。
        //
        //假如你不加这个注解的话，当你在用一个较新的api方法时候，如果manifest文件中定义的minSdk比这个方法对应的版本要低，Lint检测的时候会报错误或者警告。
        @SuppressLint("RestrictedApi") final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
