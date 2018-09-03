package com.example.yuejz.festec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.latte_core.activities.ProxyActivity;
import com.example.latte_core.app.Latte;
import com.example.latte_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegare() {
        return new ExampleDelegate();
    }
}
