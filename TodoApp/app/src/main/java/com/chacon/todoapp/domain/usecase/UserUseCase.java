package com.chacon.todoapp.domain.usecase;

import com.chacon.todoapp.domain.model.User;
import com.chacon.todoapp.helpers.Callback;

/**
 * Created by Juanpa on 2/12/2017.
 */

public interface UserUseCase {
    void login(String email, String password, boolean remember, Callback<User> callback);
    void  signUp(String fullName,String email, String password,  Callback<User> callback);

}
