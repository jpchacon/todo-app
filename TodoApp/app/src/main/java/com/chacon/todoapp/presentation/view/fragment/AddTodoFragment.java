package com.chacon.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chacon.todoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTodoFragment extends Fragment {


    public AddTodoFragment() {
        // Required empty public constructor
    }

    public AddTodoFragment getInstance(){
        return new AddTodoFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_todo,container,false);
        return view;
    }

}
