package com.app.yoga.yogaapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.app.yoga.yogaapplication.utils.PrefUtils;
import com.app.yoga.yogaapplication.R;
import com.app.yoga.yogaapplication.adapter.MainViewAdapter;
import com.app.yoga.yogaapplication.objects.MainItemObject;
import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView btnLogout;
    private LinearLayoutManager lLayout;

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
    protected void onResume() {
        super.onResume();

        List<MainItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(MainActivity.this);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        MainViewAdapter rcAdapter = new MainViewAdapter(MainActivity.this,rowListItem);
        rView.setAdapter(rcAdapter);
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

    private List<MainItemObject> getAllItemList(){

        List<MainItemObject> allItems = new ArrayList<MainItemObject>();
        allItems.add(new MainItemObject("Live Stream", R.drawable.group_join));
        allItems.add(new MainItemObject("Book Your Class", R.drawable.exercise_class));

        return allItems;
    }
}
