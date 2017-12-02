package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.domain.model.User;
import com.chacon.todoapp.domain.usecase.UserUseCase;
import com.chacon.todoapp.domain.usecase.impl.UserUseCaseImpl;
import com.chacon.todoapp.helpers.Callback;
import com.chacon.todoapp.presentation.interfaces.LoginContract;

/**
 * Created by Juanpa on 30/11/2017.
 */

public class LoginPresenter implements LoginContract.UserActionsListener{

    private LoginContract.View view;
    private UserUseCase userUseCase;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onLogin(final String email, String password, boolean remember) {
        userUseCase.login(email, password, remember, new Callback<User>() {
            @Override
            public void success(User result) {
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.showMenssageError(error);
            }
        });

    }
}
