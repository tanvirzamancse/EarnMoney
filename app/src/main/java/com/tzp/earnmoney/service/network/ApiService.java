package com.tzp.earnmoney.service.network;

import com.tzp.earnmoney.service.model.auth.LoginResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/login")
    @FormUrlEncoded
    Observable<LoginResponse> doLogin(

            @Field("email") String Email,
            @Field("password") String Password

    );
}
