package com.example.latte_core.net.download;

import android.os.AsyncTask;

import com.example.latte_core.net.RestCreator;
import com.example.latte_core.net.callback.IError;
import com.example.latte_core.net.callback.IFailure;
import com.example.latte_core.net.callback.IRequest;
import com.example.latte_core.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadHandler {

    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public DownloadHandler(String url,
                           WeakHashMap<String, Object> params,
                           IRequest requset,
                           String downloadDir,
                           String extension,
                           String name,
                           ISuccess success,
                           IFailure failure,
                           IError error) {
        this.URL = url;
        this.PARAMS = params;
        this.REQUEST = requset;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
    }

    public final void handleDownload(){
        if (REQUEST != null){
            REQUEST.onRequsetStart();
        }
        RestCreator.getRestService().download(URL,PARAMS)
            .enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                   if (response.isSuccessful()){
                       final ResponseBody responseBody = response.body();
                       final SaveFileTask task = new SaveFileTask(REQUEST,SUCCESS);
                       task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,DOWNLOAD_DIR,EXTENSION,response,NAME);
                       //一定要判断，否则下载不全
                       if (task.isCancelled()){
                           if (REQUEST != null){
                               REQUEST.onRequestEnd();
                           }
                       }else {
                           if (ERROR != null){
                               ERROR.onError(response.code(),response.message());
                           }
                       }
                   }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    if (FAILURE !=null){
                        FAILURE.onFailure();
                    }
                }
            });
    }
}
