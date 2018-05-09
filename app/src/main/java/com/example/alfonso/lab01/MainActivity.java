package com.example.alfonso.lab01;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    protected String token;
    private NetworkManager networkManager;

    private static final String DATABASE_NAME = "forms_db";
    public AppDatabase appDatabase;
    static SPManager spManager = new SPManager();
    static SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkManager = NetworkManager.getInstance(this);

        sharedPref = getApplicationContext().getSharedPreferences("com.example.lab2.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration().build();
        token = sharedPref.getString("token", "");

        if (Objects.equals(token, "")){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
        }
        networkManager.setToken(token);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        if(menuItem.getItemId() == R.id.nav_form) {
                            FormFragment fragment = new FormFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                                    fragment).commit();
                        }

                        else if(menuItem.getItemId() == R.id.nav_resume) {
                            ResumeFragment fragment = new ResumeFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                                    fragment).commit();
                        }

                        else if(menuItem.getItemId() == R.id.nav_list) {
                            ListFragment fragment = new ListFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                                    fragment).commit();
                        }


                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.log_out_button:
                sharedPref.edit().clear().commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, 0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                spManager.addToken(this, data.getStringExtra("token"));
            }
        }
    }
}

