package com.chacon.todoapp.presentation.interfaces;

import java.util.Date;

/**
 * Created by Juanpa on 8/12/2017.
 */

public interface AddTodoContract {
    interface View {
        void goToTodoListFragment();

        void showMessageError(Exception error);
    }

    interface UserActionsListener {
        void onSave(String description, boolean finished, Date finishDate, String image);
    }
}
