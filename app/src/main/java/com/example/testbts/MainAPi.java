package com.example.testbts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MainAPi {

    @GET("checklist")
    Call<List<String>> getAll(
    );


    @POST("login")
    Call<String> postLogin(
            @Body loginModel loginModel
    );


    @POST("register")
    Call<String> postRegister(
            @Body registerModel registerModel
    );


}
