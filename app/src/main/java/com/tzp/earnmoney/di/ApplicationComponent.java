package com.tzp.earnmoney.di;

import com.tzp.earnmoney.service.network.RetrofitClient;
import com.tzp.earnmoney.view.ui.auth.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

public interface ApplicationComponent {

    void inject(LoginFragment loginFragment);

}
