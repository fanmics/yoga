package com.app.yoga.yogaapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.app.yoga.yogaapplication.PrefUtils;
import com.app.yoga.yogaapplication.R;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnLogout = (TextView) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnLogout:
                PrefUtils.clearCurrentUser(MainActivity.this);

                // We can logout from facebook by calling following method
                LoginManager.getInstance().logOut();

                Intent i= new Intent(MainActivity.this,LoginMainActivity.class);
                startActivity(i);
                finish();
                break;
        }

    }
}
