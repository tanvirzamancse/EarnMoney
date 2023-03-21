package com.tzp.earnmoney.service.repository.remotedatasource;

import android.content.Context;

import com.tzp.earnmoney.service.model.auth.LoginResponse;
import com.tzp.earnmoney.service.network.RetrofitClient;

import javax.inject.Singleton;

import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.Single;

public class AuthRepository {
    private static AuthRepository authRepository;
    private static Context context;

    public static AuthRepository getAuthRepository(Context context1){
        if (authRepository == null) {
            context=context1;
            authRepository=new AuthRepository();
        }
        return authRepository;
    }
    public Observable<LoginResponse> doLogin() {
        return RetrofitClient.getApiService().doLogin();

    }
}
