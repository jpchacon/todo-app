package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.domain.usecase.UserUseCase;
import com.chacon.todoapp.domain.usecase.impl.UserUseCaseImpl;
import com.chacon.todoapp.helpers.Callback;
import com.chacon.todoapp.presentation.interfaces.RecoveryPasswordContract;

/**
 * Created by Juanpa on 4/12/2017.
 */

public class RecoveryPasswordPresenter implements RecoveryPasswordContract.presenter{

    private RecoveryPasswordContract.view view;
    private UserUseCase userUseCase;

    public RecoveryPasswordPresenter(RecoveryPasswordContract.view view){
        this.view = view;
        userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void attempSendMail(String email) {
        if (view != null){
            view.showProgressbar();
            userUseCase.recoveryPassword(email, new Callback<Boolean>() {
                @Override
                public void success(Boolean result) {
                    view.hideProgressbar();
                    view.showSuccessfull();
                }

                @Override
                public void error(Exception error) {
                    view.hideProgressbar();
                    view.showFailed(error);
                }
            });

        }
    }


}
