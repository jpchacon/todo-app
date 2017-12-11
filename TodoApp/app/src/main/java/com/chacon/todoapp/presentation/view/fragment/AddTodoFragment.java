package com.chacon.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chacon.todoapp.R;
import com.chacon.todoapp.helpers.Utilitis;
import com.chacon.todoapp.presentation.interfaces.AddTodoContract;
import com.chacon.todoapp.presentation.presenter.AddTodoPresenter;
import com.chacon.todoapp.presentation.view.activity.MainActivity;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTodoFragment extends Fragment implements AddTodoContract.View, View.OnClickListener{

    private AddTodoContract.UserActionsListener actionsListener;

    private TextInputLayout tilDescriptionTodo;
    private EditText edtFinalizaEl;
    private Button btnCalendario;
    private Button btnBlack;
    private Button btnOrange;
    private Button btnRed;
    private ImageView imvFotoTodo;
    private Button btnSaveTodo;
    private FloatingActionButton fab;

    private int color;


    public AddTodoFragment() {
        // Required empty public constructor
    }

    public static AddTodoFragment getInstance(){
        return new AddTodoFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_todo,container,false);

        actionsListener = new AddTodoPresenter(this);

        color = 0;

        fab = getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.GONE);

        tilDescriptionTodo = view.findViewById(R.id.tilDescriptionTodo);
        edtFinalizaEl = view.findViewById(R.id.edtFinalizaEl);
        btnCalendario = view.findViewById(R.id.btnCalendario);
        btnBlack = view.findViewById(R.id.btnBlack);
        btnOrange = view.findViewById(R.id.btnOrange);
        btnRed = view.findViewById(R.id.btnRed);
        btnSaveTodo = view.findViewById(R.id.btnSaveTodo);
        imvFotoTodo = view.findViewById(R.id.imvFotoTodo);

        btnCalendario.setOnClickListener(this);
        btnBlack.setOnClickListener(this);
        btnOrange.setOnClickListener(this);
        btnRed.setOnClickListener(this);
        btnSaveTodo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalendario:
                break;
            case R.id.btnBlack:
                color = getResources().getColor(R.color.btn_color_todo_1);
                break;
            case R.id.btnOrange:
                color = getResources().getColor(R.color.btn_color_todo_2);
                break;
            case R.id.btnRed:
                color = getResources().getColor(R.color.btn_color_todo_3);
                break;
            case R.id.btnSaveTodo:
                break;
        }
    }

    public void onSave(){
        try {
            boolean result = true;
            String description = tilDescriptionTodo.getEditText().getText().toString();
            Date finishDate = new Date();
            if (Utilitis.isEmpty(description)){
                tilDescriptionTodo.setError(getString(R.string.is_required));
                tilDescriptionTodo.setErrorEnabled(true);
                result = false;
            }else {
                tilDescriptionTodo.setError(null);
                tilDescriptionTodo.setErrorEnabled(false);
            }

            if (color == 0){
                Snackbar.make(getView(),"Se requiere un color de Todo",Snackbar.LENGTH_SHORT).show();
                result = false;
            }

            if (result){
                actionsListener.onSave(description,false,finishDate,"");
            }


        }catch (Exception error){
            showMessageError(error);
        }
    }

    @Override
    public void goToTodoListFragment() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.replaceFragment(TodoListFragment.getInstance(), true);
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        fab.setVisibility(View.VISIBLE);
        super.onDestroyView();
    }
}
