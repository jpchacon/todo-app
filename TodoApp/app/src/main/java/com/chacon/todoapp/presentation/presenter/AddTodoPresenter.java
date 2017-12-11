package com.chacon.todoapp.presentation.presenter;

import com.chacon.todoapp.domain.model.Todo;
import com.chacon.todoapp.domain.usecase.TodoUseCase;
import com.chacon.todoapp.domain.usecase.impl.TodoUseCaseImpl;
import com.chacon.todoapp.helpers.Callback;
import com.chacon.todoapp.presentation.interfaces.AddTodoContract;

import java.util.Date;

/**
 * Created by Juanpa on 8/12/2017.
 */

public class AddTodoPresenter implements AddTodoContract.UserActionsListener{

    private AddTodoContract.View view;
    private TodoUseCase todoUseCase;

    public AddTodoPresenter(AddTodoContract.View view){
        this.view = view;
        this.todoUseCase = new TodoUseCaseImpl();
    }

    @Override
    public void onSave(String description, boolean finished, Date finishDate, String image) {
        todoUseCase.insert(description, finishDate, false, image, 0, new Callback<Todo>() {
            @Override
            public void success(Todo result) {
                view.goToTodoListFragment();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }
}
