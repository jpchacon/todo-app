package com.chacon.todoapp.repository;

import com.chacon.todoapp.domain.model.Todo;

import java.util.List;

/**
 * Created by Juanpa on 7/12/2017.
 */

public interface TodoRepository {

    Long insert(Todo todo);

    void update(Todo todo);

    void delete(Todo todo);

    List<Todo> getAll();

}
