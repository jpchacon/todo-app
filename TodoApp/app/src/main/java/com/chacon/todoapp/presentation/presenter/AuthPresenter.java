package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.presentation.interfaces.AuthContract;

/**
 * Created by Juanpa on 30/11/2017.
 */

public class AuthPresenter implements AuthContract.UserActionsListener {

    private AuthContract.View view;

    public AuthPresenter(AuthContract.View view){
        this.view = view;
    }

    @Override
    public void goToFirstFragment() {
        view.goToLoginFragment();

        //view.goToMainActivity();
    }
}
