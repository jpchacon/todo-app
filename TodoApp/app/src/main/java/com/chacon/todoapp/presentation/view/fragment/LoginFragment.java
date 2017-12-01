package com.chacon.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.chacon.todoapp.R;
import com.chacon.todoapp.helpers.Utilitis;
import com.chacon.todoapp.presentation.interfaces.LoginContract;
import com.chacon.todoapp.presentation.presenter.LoginPresenter;
import com.chacon.todoapp.presentation.view.activity.AuthActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View{

    private LoginContract.UserActionsListener mActionListener;

    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private TextView tvForgotPassword;
    private Switch swRemember;
    private Button btnStart;
    private Button btnNotHaveAccount;


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance(){
        return new  LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);

        mActionListener = new LoginPresenter(this);

        tilEmail = view.findViewById(R.id.tilEmail);
        tilPassword = view.findViewById(R.id.tilPassword);
        tvForgotPassword = view.findViewById(R.id.tvForgotPassword);
        swRemember = view.findViewById(R.id.swRemember);
        btnStart = view.findViewById(R.id.btnStart);
        btnNotHaveAccount = view.findViewById(R.id.btnNotHaveAccount);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogin();
            }
        });

        btnNotHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });







        return view;
    }

    @Override
    public void goToSignUpFragment() {
        AuthActivity authActivity = (AuthActivity)getActivity();
        authActivity.replaceFragment(SignUpFragment.getInstance(),false);
    }

    @Override
    public void goToMainActivity() {

    }

    private void onLogin(){
        try {
            boolean result = true;
            String email = tilEmail.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();
            boolean remember = swRemember.isChecked();

            if (Utilitis.isEmpty(email)){
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setErrorEnabled(true);
                result = false;
            }else {
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }

            if (Utilitis.isEmpty(password)){
                tilPassword.setError(getString(R.string.is_required));
                tilPassword.setErrorEnabled(true);
                result = false;
            }else {
                tilPassword.setError(null);
                tilPassword.setErrorEnabled(false);
            }

            //Si la validacion no genera errores
            if (result){
                mActionListener.onLogin(email,password,remember);
            }

        }catch (Exception e){

        }
    }
}
