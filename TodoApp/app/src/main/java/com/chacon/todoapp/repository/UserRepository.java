package com.chacon.todoapp.repository;

import com.chacon.todoapp.domain.model.User;
import com.chacon.todoapp.helpers.Callback;

/**
 * Created by Juanpa on 30/11/2017.
 */

public interface UserRepository {

    void login(String email, String password, Callback<User> callback);

    void  signUp(User user,  Callback<User> callback);




}
