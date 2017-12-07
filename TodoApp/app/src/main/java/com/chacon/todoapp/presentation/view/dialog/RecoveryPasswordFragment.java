package com.chacon.todoapp.presentation.view.dialog;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chacon.todoapp.R;
import com.chacon.todoapp.helpers.Utilitis;
import com.chacon.todoapp.presentation.interfaces.RecoveryPasswordContract;
import com.chacon.todoapp.presentation.presenter.RecoveryPasswordPresenter;

import static com.chacon.todoapp.R.id.tilEmail;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecoveryPasswordFragment extends DialogFragment implements RecoveryPasswordContract.view, View.OnClickListener{

    private RecoveryPasswordContract.presenter presenter;

    private TextInputLayout emailRecoveryEdit;
    private TextView recoveryPassTextView, msjAlerta,recoveryPassAccept;
    private ProgressBar progressBarRecovery;
    private View view;

    public RecoveryPasswordFragment() {

    }

    public static RecoveryPasswordFragment getInstance(){
        return new RecoveryPasswordFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recover_password,null);

        presenter = new RecoveryPasswordPresenter(this);

        emailRecoveryEdit = view.findViewById(R.id.emailRecoveryEdit);
        recoveryPassTextView = view.findViewById(R.id.recoveryPassTextView);
        progressBarRecovery = view.findViewById(R.id.progressBarRecovery);
        recoveryPassAccept = view.findViewById(R.id.recoveryPassAccept);
        msjAlerta = view.findViewById(R.id.msjAlerta);

        recoveryPassTextView.setOnClickListener(this);
        recoveryPassAccept.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.recoveryPassTextView:
                onRecovery();
                break;
            case R.id.recoveryPassAccept:
                dismiss();
                break;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        return builder.create();
    }

    private void onRecovery() {
        try {
            boolean result = true;

            String email = emailRecoveryEdit.getEditText().getText().toString();
            if(Utilitis.isEmpty(email)) {
                emailRecoveryEdit.setError(getString(R.string.is_required));
                emailRecoveryEdit.setErrorEnabled(true);
                result = false;
            } else {
                emailRecoveryEdit.setError(null);
                emailRecoveryEdit.setErrorEnabled(false);
            }

            if(result) {
                presenter.attempSendMail(email);
            }
        } catch (Exception e) {
            showFailed(e);
        }
    }

    @Override
    public void showSuccessfull() {
        msjAlerta.setText(R.string.mensaje_succes_recovery_email);
        msjAlerta.setTextColor(getResources().getColor(R.color.success_email));
        recoveryPassTextView.setVisibility(View.GONE);
        recoveryPassAccept.setVisibility(View.VISIBLE);
        emailRecoveryEdit.getEditText().setText("");
    }

    @Override
    public void showFailed(Exception error) {
        msjAlerta.setText(error.getMessage());
        msjAlerta.setTextColor(getResources().getColor(R.color.error_email));
        emailRecoveryEdit.getEditText().setText("");
    }

    @Override
    public void showProgressbar() {
        progressBarRecovery.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBarRecovery.setVisibility(View.GONE);
    }




}
