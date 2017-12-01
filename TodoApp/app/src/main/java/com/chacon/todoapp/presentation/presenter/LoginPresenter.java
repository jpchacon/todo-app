package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.presentation.interfaces.LoginContract;

/**
 * Created by Juanpa on 30/11/2017.
 */

public class LoginPresenter implements LoginContract.UserActionsListener{

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onLogin(String main, String password, boolean remember) {

    }
}
