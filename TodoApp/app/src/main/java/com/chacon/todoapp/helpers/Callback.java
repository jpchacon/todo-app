package com.chacon.todoapp.helpers;

import com.chacon.todoapp.domain.model.User;

/**
 * Created by Juanpa on 2/12/2017.
 */

public interface Callback<T>{

    void success(T result);
    void error(Exception error);
}
