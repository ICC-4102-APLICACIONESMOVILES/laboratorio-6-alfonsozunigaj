package com.example.alfonso.lab01;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {

    private static final String DATABASE_NAME = "forms_db";

    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        Button send = (Button) view.findViewById(R.id.button_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                sendToDatabase(view);
                ListFragment fragment = new ListFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                        fragment).commit();
            }
        });
        return view;
    }

    public void sendToDatabase(View view) {
        final AppDatabase formDatabase = Room.databaseBuilder(view.getContext(), AppDatabase.class,
                DATABASE_NAME).fallbackToDestructiveMigration().build();

        EditText editTextName = (EditText) view.getRootView().findViewById(R.id.editTextName);
        final String name = editTextName.getText().toString();
        if(Objects.equals(name, "")) { return; }
        EditText editTextDate = (EditText) view.getRootView().findViewById(R.id.editTextDate);
        final String date = editTextDate.getText().toString();
        if(Objects.equals(date, "")) { return; }

        Spinner editTextCategory = (Spinner) view.getRootView().findViewById(R.id.editTextCategory);
        final String category = editTextCategory.getSelectedItem().toString();
        if(Objects.equals(category, "")) { return; }

        EditText editTextDescription = (EditText) view.getRootView().findViewById(R.id.editTextComentary);
        final String description = editTextDescription.getText().toString();
        if(Objects.equals(description, "")) { return; }

        new Thread(new Runnable() {
            @Override
            public void run() {
                Form form = new Form();
                form.setName(name);
                form.setDate(date);
                form.setCategory(category);
                form.setDescription(description);

                formDatabase.formDao().insert(form);
            }
        }).start();
    }

}
