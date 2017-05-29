package com.example.caoniaowoweibo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;


import com.example.caoniaowoweibo.R;

/**
 * Created by Administrator on 2017/5/15.
 */

public abstract class BaseActivity extends AppCompatActivity{

//    private TextView tvtitle;
      private RelativeLayout rlContent;
      private Toolbar toolbar;//+
      private ToolBarX toolBarX;//+

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_baselayout);//有改动 本来是一个TextView
//        setTheme(R.style.AppTheme.);
        toolbar=(Toolbar)findViewById(R.id.toolbar1); //+
        rlContent=(RelativeLayout)findViewById(R.id.rlContent);
        View v=getLayoutInflater().inflate(getLayoutId(),rlContent,false);//IOC 控制反转 在父类中调用子类的实现
        rlContent.addView(v);
        ToolBarX toolBarX=new ToolBarX(toolbar,this);
//        toolbar.setLogo(R.drawable.bg_ic_launcher);
//        toolbar.setTitle("123");
//        toolbar.setSubtitle("456");
//        setSupportActionBar(toolbar);
    }

    public abstract int getLayoutId();

    @Override
    public void startActivity(Intent intent){
        super.startActivity(intent);
        overridePendingTransition(R.anim.anim_in_right_left,R.anim.anim_out_right_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_in_left_right,R.anim.anim_out_left_right);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        overridePendingTransition(R.anim.anim_in_right_left,R.anim.anim_out_right_left);
    }

    public ToolBarX getToolBar() {
        if (toolBarX ==null) {
            toolBarX =new ToolBarX(toolbar,this);
        }
        return toolBarX;
    }
}
