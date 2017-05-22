package com.example.caoniaowoweibo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.caoniaowoweibo.R;

/**
 * Created by Administrator on 2017/5/15.
 */

public abstract class BaseActivity extends AppCompatActivity{

//    private TextView tvtitle;
    private RelativeLayout rlcontent;
    private Toolbar toolbar;//+
    private ToolBarX toolBarX;//+

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.ac_baselayout);//有改动 本来是一个TextView
//        tvtitle=(TextView)findViewById(R.id.tvtitle);
        toolbar=(Toolbar)findViewById(R.id.toolBar); //+
        rlcontent=(RelativeLayout)findViewById(R.id.rlcontent);
        View v=getLayoutInflater().inflate(getLayoutId(),rlcontent,false);//IOC 控制反转 在父类中调用子类的实现
        rlcontent.addView(v);
        toolBarX=new ToolBarX(toolbar,this);
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
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        overridePendingTransition(R.anim.anim_in_right_left,R.anim.anim_out_right_left);
    }

    public ToolBarX getToolBar() {
        if (null == toolBarX) {
            toolBarX=new ToolBarX(toolbar,this);
        }
        return toolBarX;
    }
}
