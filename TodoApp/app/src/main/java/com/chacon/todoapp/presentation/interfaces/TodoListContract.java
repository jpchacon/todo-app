package com.chacon.todoapp.presentation.interfaces;

import com.chacon.todoapp.domain.model.Todo;

import java.util.List;

/**
 * Created by Juanpa on 8/12/2017.
 */

public interface TodoListContract {
    interface View {

        void refreshTodos();

    }

    interface UserActionsListener {

        void loadAll();

        List<Todo> getLstTodos();

    }
}
