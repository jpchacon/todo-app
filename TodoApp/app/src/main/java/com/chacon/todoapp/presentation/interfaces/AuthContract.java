package com.chacon.todoapp.presentation.interfaces;

/**
 * Created by Juanpa on 30/11/2017.
 */

public interface AuthContract {

    //Interface que implementara el fragment o Activity
    interface View{
        void goToLoginFragment();
        void goToMainActivity();
    }

    //Interface que implementara el presenter
    interface UserActionsListener{
        void goToFirstFragment();
    }
}
