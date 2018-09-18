package com.example.latte.ec.sign;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.latte.ec.database.DataBaseManager;
import com.example.latte.ec.database.UserProfile;
import com.example.latte_core.app.AccountManager;

import java.util.UUID;

public class SignHandler {

    public static void onSignIn(String response,ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");

        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender,
                address);
        Log.d("profile",profile.toString());
        DataBaseManager.getInstance().getDao().insert(profile);
      //  DataBaseManager.getInstance().getDao().insertOrReplace(profile);
        //已经注册并登录
        AccountManager.setSignState(true);
        signListener.onSignInSuccess();
    }


    public static void onSignUp(String response,ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");

         final long userId = profileJson.getLong("userId");
    //    final long userId = System.currentTimeMillis();

        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
     //   Log.d("id",String.valueOf(userId));

        final UserProfile profile = new UserProfile(userId, name, avatar, gender,
                address);
        DataBaseManager.getInstance().getDao().insert(profile);

        //已经注册并登录
        AccountManager.setSignState(true);
        signListener.onSignUpSuccess();
    }

}
