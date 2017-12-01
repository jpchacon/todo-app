package com.chacon.todoapp.presentation.interfaces;

/**
 * Created by Juanpa on 30/11/2017.
 */

public interface SingnUpContract {
    interface View{
        void goToLoginFragment();
        void goToMainActivity();
    }
    interface UserActionsListener{
        void onSignUp(String fullName,String email, String password);
    }
}
