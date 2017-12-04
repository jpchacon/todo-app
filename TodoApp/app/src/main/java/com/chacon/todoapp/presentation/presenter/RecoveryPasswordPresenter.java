package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.domain.usecase.impl.RecoveryPasswordInteractorImpl;
import com.chacon.todoapp.helpers.OnRecoveryPasswordFinishedListener;
import com.chacon.todoapp.presentation.interfaces.RecoveryPasswordContract;

/**
 * Created by Juanpa on 4/12/2017.
 */

public class RecoveryPasswordPresenter implements RecoveryPasswordContract.presenter, OnRecoveryPasswordFinishedListener {

    private RecoveryPasswordContract.view view;
    private RecoveryPasswordContract.interactor interactor;

    public RecoveryPasswordPresenter(RecoveryPasswordContract.view view){
        this.view = view;
        interactor = new RecoveryPasswordInteractorImpl(this);
    }

    @Override
    public void attempSendMail(String email) {
        if (view != null){
            view.showProgressbar();
            interactor.sendMail(this,email);
        }
    }

    @Override
    public void onSucces() {
        if (view != null){
            view.hideProgressbar();
            view.showSuccessfull();
        }
    }

    @Override
    public void onError() {
        if (view != null){
            view.hideProgressbar();
            view.showFailed();
        }
    }
}
