package com.chacon.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chacon.todoapp.R;
import com.chacon.todoapp.presentation.interfaces.SingnUpContract;
import com.chacon.todoapp.presentation.view.activity.AuthActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements SingnUpContract.View{

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


        return view;
    }

    @Override
    public void goToLoginFragment() {
        getChildFragmentManager().popBackStack();
    }

    @Override
    public void goToMainActivity() {

    }
}
