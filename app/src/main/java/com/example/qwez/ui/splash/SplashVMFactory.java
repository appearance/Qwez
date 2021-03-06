package com.example.qwez.ui.splash;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.qwez.interactor.GetUserInteractor;
import com.example.qwez.router.LoginRouter;
import com.example.qwez.router.StartRouter;

public class SplashVMFactory implements ViewModelProvider.Factory {

    private final StartRouter startRouter;
    private final GetUserInteractor getUserInteractor;
    private final LoginRouter loginRouter;

    SplashVMFactory(StartRouter startRouter, GetUserInteractor getUserInteractor, LoginRouter loginRouter) {
        this.startRouter = startRouter;
        this.getUserInteractor = getUserInteractor;
        this.loginRouter = loginRouter;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SplashViewModel(startRouter, loginRouter, getUserInteractor);
    }

}
