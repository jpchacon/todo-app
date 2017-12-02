package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.domain.model.User;
import com.chacon.todoapp.domain.usecase.UserUseCase;
import com.chacon.todoapp.domain.usecase.impl.UserUseCaseImpl;
import com.chacon.todoapp.helpers.Callback;
import com.chacon.todoapp.presentation.interfaces.SingnUpContract;

/**
 * Created by Juanpa on 30/11/2017.
 */

public class SignUpPresenter implements SingnUpContract.UserActionsListener {

    private SingnUpContract.View view;
    private UserUseCase userUseCase;

    public SignUpPresenter(SingnUpContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }


    @Override
    public void onSignUp(String fullName, final String email, String password) {
        userUseCase.signUp(fullName, email, password, new Callback<User>() {
            @Override
            public void success(User result) {
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }
}
