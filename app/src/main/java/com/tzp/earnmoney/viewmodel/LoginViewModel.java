package com.tzp.earnmoney.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tzp.earnmoney.service.model.auth.LoginResponse;
import com.tzp.earnmoney.service.repository.remotedatasource.AuthRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends AndroidViewModel {

    private static final int RESPONSE_SUCCESS_CODE =200 ;
    public AuthRepository authRepository;
    MutableLiveData<LoginResponse> mLivedata;
    public MutableLiveData<String> email=null;
    public MutableLiveData<String> password=null;
    private Observable<LoginResponse> single;
    private final CompositeDisposable disposables = new CompositeDisposable();


    public LoginViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getAuthRepository(application);
    }



    public int  verificationOfRequiredData()
    {
        if(email.getValue() == null || TextUtils.isEmpty(email.getValue()))
            return 1;

        if(password.getValue() == null || TextUtils.isEmpty(password.getValue()))
            return 2;
        return RESPONSE_SUCCESS_CODE;
    }


    public LiveData<LoginResponse> getLoginViewModel() {

        mLivedata = new MutableLiveData<>();

        single = authRepository.doLogin(email, password);
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Toast.makeText(getApplication(), "onSubscribe", Toast.LENGTH_SHORT).show();
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        Toast.makeText(getApplication(), "onNext", Toast.LENGTH_SHORT).show();
                        mLivedata.setValue(loginResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplication(), "onError", Toast.LENGTH_SHORT).show();
                        mLivedata.setValue(null);
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(getApplication(), "onComplete", Toast.LENGTH_SHORT).show();
                    }
                });
        return mLivedata;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
