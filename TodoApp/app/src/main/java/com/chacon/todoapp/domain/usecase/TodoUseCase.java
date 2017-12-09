package com.chacon.todoapp.domain.usecase;

import com.chacon.todoapp.domain.model.Todo;
import com.chacon.todoapp.helpers.Callback;

import java.util.Date;
import java.util.List;

/**
 * Created by Juanpa on 7/12/2017.
 */

public interface TodoUseCase {

    void insert(String description, Date finishDate, Boolean finished, String image, int color,
                Callback<Todo> callback);

    void update(Todo todo, Callback<Todo> callback);

    void delete(Todo todo, Callback<Boolean> callback);

    void getAll(Callback<List<Todo>> callback);
}
