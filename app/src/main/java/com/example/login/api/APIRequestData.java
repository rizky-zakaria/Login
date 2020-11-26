package com.example.login.api;

import com.example.login.model.login.Login;
import com.example.login.model.mahasiswa.DataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {

    @FormUrlEncoded
    @POST("Auth")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("Nilai/index_get")
    Call<DataModel> aData();

}
