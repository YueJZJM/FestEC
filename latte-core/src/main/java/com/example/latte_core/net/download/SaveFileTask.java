package com.example.latte_core.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.example.latte_core.app.Latte;
import com.example.latte_core.net.callback.IFailure;
import com.example.latte_core.net.callback.IRequest;
import com.example.latte_core.net.callback.ISuccess;
import com.example.latte_core.util.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Url;

public class SaveFileTask extends AsyncTask<Object,Void,File> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    public SaveFileTask(IRequest REQUEST, ISuccess SUCCESS) {
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
    }

    @Override
    protected File doInBackground(Object... objects) {

        String downloadDir = (String) objects[0];
        String extension = (String) objects[1];
        final ResponseBody body = (ResponseBody) objects[2];
        final String name = (String) objects[3];
        final InputStream is = body.byteStream();
        if (!TextUtils.isEmpty(downloadDir)){
            downloadDir = "dowm_loads";
        }
        if (!TextUtils.isEmpty(extension)){
            extension = "";
        }
        if (!TextUtils.isEmpty(name)){
            return FileUtil.writeToDisk(is,downloadDir,extension.toUpperCase());
        }else {
            return FileUtil.writeToDisk(is,downloadDir,name);
        }
    }
    //执行完后在主线程中的操作
    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null){
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null){
            REQUEST.onRequestEnd();
        }

        autoInstallAPK(file);
    }

    private void autoInstallAPK(File file){
        if (FileUtil.getExtension(file.getPath()).equals("apk")){
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
            Latte.getApplication().startActivity(install);
        }
    }
}
