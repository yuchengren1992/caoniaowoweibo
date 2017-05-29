package com.example.caoniaowoweibo.activity;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.caoniaowoweibo.R;

public class MainActivity extends BaseActivity {
    private Toolbar toolbar;
//    private AppCompatActivity activity;
//    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolBar().setTitle("终于好了").setSubTitle("YEAH!").setDisplayHomeAsUpEnabled(true)
                .setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
