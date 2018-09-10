package com.example.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.net.RestClient;
import com.example.latte_core.net.callback.ISuccess;
import com.example.latte_core.util.log.LatteLogger;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

public class  SignUpDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;

    private ISignListener mIsignListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener){
            mIsignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp(){
        if (chechForm()){
            RestClient.builder()
                    .url("http://oxjde2kpq.bkt.clouddn.com/user_profile.json")
                    .params("name",mName.getText().toString())
                    .params("email",mEmail.getText().toString())
                    .params("phone",mPhone.getText().toString())
                    .params("password",mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                        //    LatteLogger.json("USER_PROFILE",response);
                          //  Log.d("USER_PROFILE",response.toString());
                            SignHandler.onSignUp(response,mIsignListener);
                        }
                    })
                    .build()
                    .post();
            //Toast.makeText(getContext(),"验证通过",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLink(){
        start(new SignInDelegate());
    }


    private boolean chechForm(){
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        final String rePassword = mRePassword.getText().toString();

        boolean isPass = true;

        if (TextUtils.isEmpty(name)){
            mName.setError("请输入姓名");
            isPass = false;
        }else {
            mName.setError(null);
        }

        if (TextUtils.isEmpty(email)|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }else {
            mEmail.setError(null);
        }

        if (TextUtils.isEmpty(phone) || phone.length() != 11){
            mPhone.setError("手机号码错误");
            isPass = false;
        }else {
            mPhone.setError(null);
        }

        if (TextUtils.isEmpty(password) || password.length() < 6){
            mPassword.setError("密码至少六位");
            isPass = false;
        }else {
            mPassword.setError(null);
        }

        if (TextUtils.isEmpty(rePassword) || rePassword.length() < 6 || !rePassword.equals(password)){
            mRePassword.setError("密码验证错误");
            isPass = false;
        }else {
            mRePassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
