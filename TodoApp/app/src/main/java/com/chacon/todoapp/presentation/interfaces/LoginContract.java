package com.chacon.todoapp.presentation.interfaces;

/**
 * Created by Juanpa on 30/11/2017.
 */

public interface LoginContract {
    interface View{
        void goToSignUpFragment();

        void goToMainActivity();

        void showMenssageError(Exception error);
    }
    interface UserActionsListener{
        void onLogin(String email, String password, boolean remember);
    }
}
