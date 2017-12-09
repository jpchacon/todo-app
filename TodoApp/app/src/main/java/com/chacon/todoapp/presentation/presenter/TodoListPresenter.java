package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.domain.model.Todo;
import com.chacon.todoapp.domain.usecase.TodoUseCase;
import com.chacon.todoapp.domain.usecase.impl.TodoUseCaseImpl;
import com.chacon.todoapp.helpers.Callback;
import com.chacon.todoapp.presentation.interfaces.TodoListContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juanpa on 8/12/2017.
 */

public class TodoListPresenter implements TodoListContract.UserActionsListener {

    private TodoListContract.View view;
    private TodoUseCase useCase;
    private List<Todo> listTodo;

    public TodoListPresenter(TodoListContract.View view){
        this.view = view;
        this.useCase = new TodoUseCaseImpl();
        listTodo = new ArrayList<>(0);



    }
    @Override
    public void loadAll() {
        useCase.getAll(new Callback<List<Todo>>() {
            @Override
            public void success(List<Todo> result) {
                //Se hace clear sobre la instancia del lstTodos para evitar que el adapter quede
                //con una referencia vieja de los datos cuando se actualicen
                listTodo.clear();
                listTodo.addAll(result);
            }

            @Override
            public void error(Exception error) {
                //TODO MOSTRAR ERROR
                //view.showErrorMessage(error);
            }
        });

    }

    @Override
    public List<Todo> getLstTodos() {
        return listTodo;
    }
}
