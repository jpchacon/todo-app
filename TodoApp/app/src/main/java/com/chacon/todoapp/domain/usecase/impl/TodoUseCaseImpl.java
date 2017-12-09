package com.chacon.todoapp.domain.usecase.impl;

import com.chacon.todoapp.domain.model.Todo;
import com.chacon.todoapp.domain.usecase.TodoUseCase;
import com.chacon.todoapp.helpers.Callback;
import com.chacon.todoapp.helpers.ThreadExecutor;
import com.chacon.todoapp.repository.TodoRepository;
import com.chacon.todoapp.repository.impl.TodoLocalRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Juanpa on 7/12/2017.
 */

public class TodoUseCaseImpl implements TodoUseCase {

    private TodoRepository todoRepository;

    public TodoUseCaseImpl(){
        this.todoRepository = new TodoLocalRepository();
    }

    @Override
    public void insert(final String description, final Date finishDate, final Boolean finished, final String image, final int color, final Callback<Todo> callback) {
        new ThreadExecutor<Todo>(new ThreadExecutor.Task<Todo>() {
            @Override
            public Todo execute() throws Exception {
                Todo todo = new Todo(description,finishDate,finished,image,color);
                todoRepository.insert(todo);
                return todo;
            }

            @Override
            public void finish(Exception error, Todo result) {
                if(error != null){
                    callback.error(error);
                }else {
                    callback.success(result);
                }
            }
        }).execute();
    }

    @Override
    public void update(final Todo todo, final Callback<Todo> callback) {
        //TODO Revisar
        new ThreadExecutor<Todo>(new ThreadExecutor.Task<Todo>() {
            @Override
            public Todo execute() throws Exception {
                Todo todo1 = todo;
                todoRepository.update(todo1);
                return null;
            }

            @Override
            public void finish(Exception error, Todo result) {
                if (error != null){
                    callback.error(error);
                }else {
                    callback.success(result);
                }
            }
        }).execute();
    }

    @Override
    public void delete(final Todo todo, final Callback<Boolean> callback) {
        //TODO Revisar
        new ThreadExecutor<Todo>(new ThreadExecutor.Task<Todo>() {
            @Override
            public Todo execute() throws Exception {
                Todo todo1 = todo;
                todoRepository.delete(todo);
                return null;
            }

            @Override
            public void finish(Exception error, Todo result) {
                if (error != null){
                    callback.error(error);
                }else {
                    callback.success(true);
                }
            }
        }).execute();
    }

    @Override
    public void getAll(final Callback<List<Todo>> callback) {
        new ThreadExecutor<List<Todo>>(new ThreadExecutor.Task<List<Todo>>() {
            @Override
            public List<Todo> execute() throws Exception {
                return todoRepository.getAll();
            }

            @Override
            public void finish(Exception error, List<Todo> result) {
                if(error != null){
                    callback.error(error);
                }else{
                    callback.success(result);
                }
            }
        }).execute();
    }
}
