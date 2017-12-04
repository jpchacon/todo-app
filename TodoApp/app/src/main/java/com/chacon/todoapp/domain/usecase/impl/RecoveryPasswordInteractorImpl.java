package com.chacon.todoapp.domain.usecase.impl;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.chacon.todoapp.helpers.OnRecoveryPasswordFinishedListener;
import com.chacon.todoapp.presentation.interfaces.RecoveryPasswordContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.Task;

/**
 * Created by Juanpa on 4/12/2017.
 */

public class RecoveryPasswordInteractorImpl implements RecoveryPasswordContract.interactor {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private RecoveryPasswordContract.presenter presenter;

    public RecoveryPasswordInteractorImpl(RecoveryPasswordContract.presenter presenter){
        this.presenter = presenter;
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void sendMail(final OnRecoveryPasswordFinishedListener listener, final String email) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    listener.onSucces();
                                }else {
                                    listener.onError();
                                }
                            }
                        });
            }
        },3000);
    }
}
