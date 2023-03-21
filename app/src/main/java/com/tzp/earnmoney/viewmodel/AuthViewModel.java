package com.tzp.earnmoney.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tzp.earnmoney.service.model.auth.LoginResponse;
import com.tzp.earnmoney.service.repository.remotedatasource.AuthRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
@HiltViewModel
public class AuthViewModel extends AndroidViewModel {
    @Inject
    public AuthRepository authRepository;
    MutableLiveData<LoginResponse> mLivedata;
    MutableLiveData<LoginResponse> mLive;
    private Observable<LoginResponse> single;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    public AuthViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getAuthRepository(application);
    }

    public LiveData<LoginResponse> getLoginViewModel(String Email, String Password) {

        mLivedata = new MutableLiveData<>();

        single = authRepository.doLogin(Email, Password);
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
