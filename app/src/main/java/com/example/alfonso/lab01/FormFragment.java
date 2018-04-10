package com.example.alfonso.lab01;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


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
                sendToDatabase(view);
            }
        });
        return view;
    }

    public void sendToDatabase(View view) {
        final AppDatabase formDatabase = Room.databaseBuilder(view.getContext(), AppDatabase.class,
                DATABASE_NAME).fallbackToDestructiveMigration().build();

        EditText editTextName = (EditText) view.getRootView().findViewById(R.id.editTextName);
        final String name = editTextName.getText().toString();

        EditText editTextDate = (EditText) view.getRootView().findViewById(R.id.editTextDate);
        final String date = editTextDate.getText().toString();

        Spinner editTextCategory = (Spinner) view.getRootView().findViewById(R.id.editTextCategory);
        final String category = editTextCategory.getSelectedItem().toString();

        EditText editTextDescription = (EditText) view.getRootView().findViewById(R.id.editTextComentary);
        final String description = editTextDescription.getText().toString();

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
