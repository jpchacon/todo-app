package com.chacon.todoapp.repository;

import com.chacon.todoapp.domain.model.User;

/**
 * Created by Juanpa on 30/11/2017.
 */

public interface UserRepository {

    void login(String email, String password);

    void  signUp(User user);

}
