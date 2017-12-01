package com.chacon.todoapp.presentation.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chacon.todoapp.R;
import com.chacon.todoapp.presentation.interfaces.AuthContract;
import com.chacon.todoapp.presentation.presenter.AuthPresenter;
import com.chacon.todoapp.presentation.view.fragment.LoginFragment;

public class AuthActivity extends AppCompatActivity implements AuthContract.View{

    private AuthContract.UserActionsListener mActionsListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mActionsListener = new AuthPresenter(this);
        mActionsListener.goToFirstFragment();
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack){
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);

        if(addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();

    }

    @Override
    public void goToLoginFragment() {
        replaceFragment(LoginFragment.getInstance(),true);
    }



    @Override
    public void goToMainActivity() {

    }
}
