package com.chacon.todoapp.presentation.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chacon.todoapp.R;
import com.chacon.todoapp.helpers.Utilitis;
import com.chacon.todoapp.presentation.interfaces.SingnUpContract;
import com.chacon.todoapp.presentation.presenter.SignUpPresenter;
import com.chacon.todoapp.presentation.view.activity.AuthActivity;
import com.chacon.todoapp.presentation.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements SingnUpContract.View, View.OnClickListener{

    private SingnUpContract.UserActionsListener mActionListener;

    private TextInputLayout fullNameSignUp;
    private TextInputLayout passwordSignUp;
    private TextInputLayout emailSignUp;
    private Button registroSignUp;
    private Button iHaveAccount;


    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment getInstance(){
        return new SignUpFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup,container,false);

        fullNameSignUp = view.findViewById(R.id.fullNameSignUp);
        passwordSignUp = view.findViewById(R.id.passwordSignUp);
        emailSignUp = view.findViewById(R.id.emailSignUp);

        registroSignUp = view.findViewById(R.id.registroSignUp);
        iHaveAccount = view.findViewById(R.id.iHaveAccount);

        registroSignUp.setOnClickListener(this);
        iHaveAccount.setOnClickListener(this);

        mActionListener = new SignUpPresenter(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registroSignUp:
                SignUp();
                break;
            case R.id.iHaveAccount:
                goToLoginFragment();
                break;
        }
    }

    @Override
    public void goToLoginFragment() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(),error.getMessage(),Snackbar.LENGTH_LONG).show();
    }

    private void SignUp(){
        try {
            boolean result = true;
            String fullName = fullNameSignUp.getEditText().getText().toString();
            String email = emailSignUp.getEditText().getText().toString();
            String password = passwordSignUp.getEditText().getText().toString();

            if (Utilitis.isEmpty(fullName)){
                fullNameSignUp.setError(getString(R.string.is_required));
                fullNameSignUp.setErrorEnabled(true);
                result = false;
            }else {
                fullNameSignUp.setError(null);
                fullNameSignUp.setErrorEnabled(false);
            }

            if (Utilitis.isEmpty(email)){
                emailSignUp.setError(getString(R.string.is_required));
                emailSignUp.setErrorEnabled(true);
                result = false;
            }else {
                emailSignUp.setError(null);
                emailSignUp.setErrorEnabled(false);
            }

            if (Utilitis.isEmpty(password)){
                passwordSignUp.setError(getString(R.string.is_required));
                passwordSignUp.setErrorEnabled(true);
                result = false;
            }else {
                passwordSignUp.setError(null);
                passwordSignUp.setErrorEnabled(false);
            }

            //Si la validacion no genera errores
            if (result){
                mActionListener.onSignUp(fullName,email,password);
            }

        }catch (Exception e){

        }
    }


}
