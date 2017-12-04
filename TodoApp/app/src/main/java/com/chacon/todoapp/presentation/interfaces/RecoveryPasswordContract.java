package com.chacon.todoapp.presentation.interfaces;

import com.chacon.todoapp.helpers.OnRecoveryPasswordFinishedListener;

/**
 * Created by Juanpa on 4/12/2017.
 */

public interface RecoveryPasswordContract {

    interface view{
        void showProgressbar();
        void hideProgressbar();

        void showSuccessfull();
        void showFailed();
    }

    interface presenter{
        void attempSendMail(String mail);
    }

    interface interactor{
        void sendMail(OnRecoveryPasswordFinishedListener listener, String email);
    }
}
