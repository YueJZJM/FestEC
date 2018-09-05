package com.example.latte_core.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface RestService {

    @GET
    retrofit2.Call<String> get(@Url String url, @QueryMap Map<String,Object> params);

    @FormUrlEncoded
    @POST
    retrofit2.Call<String> post(@Url String url, @FieldMap Map<String,Object> params);

    @POST
    retrofit2.Call<String>  postRaw(@Url String url, @Body RequestBody body);

    @FormUrlEncoded
    @PUT
    retrofit2.Call<String> put(@Url String url, @FieldMap Map<String,Object> params);

    @PUT
    retrofit2.Call<String> putRaw(@Url String url, @FieldMap Map<String,Object> params);

    @DELETE
    retrofit2.Call<String> delete(@Url String url, @FieldMap Map<String,Object> params);

    @Streaming  //一边下载，一边写入本地，避免内存写入过大
    @GET
    retrofit2.Call<ResponseBody> download(@Url String url, @QueryMap Map<String,Object> params);

    @Multipart
    @POST
    retrofit2.Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}
