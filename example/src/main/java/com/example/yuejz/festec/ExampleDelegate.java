package com.example.yuejz.festec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.net.RestClient;
import com.example.latte_core.net.callback.IError;
import com.example.latte_core.net.callback.IFailure;
import com.example.latte_core.net.callback.ISuccess;

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
        Log.d("testRestClient","testRestClient");
    }

    private void testRestClient(){
        RestClient.builder()
                .url("http://news.baidu.com")
             //   .params("","")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(),response,Toast.LENGTH_SHORT).show();
                        Log.d("testRestClient","success");
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d("testRestClient","failure");
                    }
                })
                .build()
                .get();
    }
}
