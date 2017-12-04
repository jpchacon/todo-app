package com.chacon.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chacon.todoapp.R;
import com.chacon.todoapp.presentation.interfaces.RecoveryPasswordContract;
import com.chacon.todoapp.presentation.presenter.RecoveryPasswordPresenter;
import com.chacon.todoapp.repository.impl.UserFirebaseRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecoveryPasswordFragment extends DialogFragment implements RecoveryPasswordContract.view, View.OnClickListener{

    private RecoveryPasswordContract.presenter presenter;

    private TextInputLayout emailRecoveryEdit;
    private TextView recoveryPassTextView;
    private ProgressBar progressBarRecovery;

    public RecoveryPasswordFragment() {

    }

    public static RecoveryPasswordFragment getInstance(){
        return new RecoveryPasswordFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recover_password,container,false);

        presenter = new RecoveryPasswordPresenter(this);

        emailRecoveryEdit = view.findViewById(R.id.emailRecoveryEdit);
        recoveryPassTextView = view.findViewById(R.id.recoveryPassTextView);
        progressBarRecovery = view.findViewById(R.id.progressBarRecovery);
        recoveryPassTextView.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.recoveryPassTextView:
                presenter.attempSendMail(emailRecoveryEdit.getEditText().getText().toString());
                break;
        }
    }


    @Override
    public void showProgressbar() {
        progressBarRecovery.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBarRecovery.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showSuccessfull() {

    }

    @Override
    public void showFailed() {

    }


}
