package com.chacon.todoapp.domain.usecase.impl;

import com.chacon.todoapp.domain.model.User;
import com.chacon.todoapp.domain.usecase.UserUseCase;
import com.chacon.todoapp.helpers.Callback;
import com.chacon.todoapp.repository.UserRepository;
import com.chacon.todoapp.repository.impl.UserFirebaseRepository;

/**
 * Created by Juanpa on 2/12/2017.
 */

public class UserUseCaseImpl implements UserUseCase {

    private UserRepository userRepository;

    public UserUseCaseImpl(){
        this.userRepository = new UserFirebaseRepository();
    }

    @Override
    public void login(String email, String password, final boolean remember, final Callback<User> callback) {
        userRepository.login(email, password, new Callback<User>() {
            @Override
            public void success(User user) {

                if(user != null && remember){
                    //TODO GUARDAR EMAIL EN SharedPreferences
                }
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void signUp(String fullName, String email, String password, final Callback<User> callback) {
        final User user = new User(fullName,email,password);
        userRepository.signUp(user, new Callback<User>() {
            @Override
            public void success(User result) {
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });

    }
}
