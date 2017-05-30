package com.example.caoniaowoweibo.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.caoniaowoweibo.R;

public class LoadingPageActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolBar().hide();//隐藏了登陆页面的ToolBar
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoadingPageActivity.this,HomePageActivity.class));
            }
        },3000);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_loading_page;
    }
}
