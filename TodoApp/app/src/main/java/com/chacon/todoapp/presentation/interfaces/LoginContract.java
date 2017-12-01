package com.chacon.todoapp.presentation.interfaces;

/**
 * Created by Juanpa on 30/11/2017.
 */

public interface LoginContract {
    interface View{
        void goToSignUpFragment();

        void goToMainActivity();
    }
    interface UserActionsListener{
        void onLogin(String main, String password, boolean remember);
    }
}
