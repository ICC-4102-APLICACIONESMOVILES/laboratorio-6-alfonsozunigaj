package com.example.alfonso.lab01;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CredentialsFragment extends Fragment {

    private String email;
    private String password;
    private SharedPreferences main_sharedPreferences;
    private View view;


    public CredentialsFragment() {
        // Required empty public constructor
    }


    public void setUpInfo(String email, String password, SharedPreferences sharedPreferences) {
        this.email = email;
        this.password = password;
        this.main_sharedPreferences = sharedPreferences;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //configureLogoutButton();
        view =  inflater.inflate(R.layout.fragment_credentials, container, false);

        TextView email_txtv = (TextView) view.findViewById(R.id.text_email);
        email_txtv.setText(email);
        TextView password_txtv = (TextView) view.findViewById(R.id.text_password);
        password_txtv.setText(password);
        return view;
    }


    /*private void configureLogoutButton() {
        Button logoutButton = (Button) view.findViewById(R.id.button_logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = main_sharedPreferences.edit();
                editor.remove("email");
                editor.remove("password");
                editor.commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }*/

}
