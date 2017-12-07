package com.chacon.todoapp.presentation.interfaces;

/**
 * Created by Juanpa on 4/12/2017.
 */

public interface RecoveryPasswordContract {

    interface view{
        void showProgressbar();
        void hideProgressbar();

        void showSuccessfull();
        void showFailed(Exception error);
    }

    interface presenter{
        void attempSendMail(String mail);
    }

}
