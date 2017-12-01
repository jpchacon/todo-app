package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.presentation.interfaces.SingnUpContract;

/**
 * Created by Juanpa on 30/11/2017.
 */

public class SignUpPresenter implements SingnUpContract.View {

    private SingnUpContract.View view;

    public SignUpPresenter(SingnUpContract.View view) {
        this.view = view;
    }

    @Override
    public void goToLoginFragment() {

    }

    @Override
    public void goToMainActivity() {

    }
}
