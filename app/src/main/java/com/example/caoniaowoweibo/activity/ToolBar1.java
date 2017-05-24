package com.example.caoniaowoweibo.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.caoniaowoweibo.R;

/**
 * Created by Administrator on 2017/5/24.
 */

public class ToolBar1 {
private Toolbar mToolbar;
private AppCompatActivity mActivity;
private ActionBar mActionbar;
private RelativeLayout rlCustom;

    public ToolBar1(){

    }

    public ToolBar1(Toolbar toolbar,AppCompatActivity activity) {
        mToolbar =toolbar;
        mActivity =activity;
        rlCustom=(RelativeLayout)toolbar.findViewById(R.id.rlCustom);
        mActivity.setSupportActionBar(mToolbar);
        mActionbar=mActivity.getSupportActionBar();
        mActionbar.setDisplayHomeAsUpEnabled(true);
//     rlCustom=(RelativeLayout)mToolbar.findViewById(R.id.rlCustom);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });

    }

    public ToolBar1 setTitle(String text){
        mActionbar.setTitle(text);
        return this;
    }

    public ToolBar1 setSubTitle(String text){
        mActionbar.setSubtitle(text);
        return this;
    }

    public ToolBar1 setTitle(int resId){
        mActionbar.setTitle(resId);
        return this;
    }

    public ToolBar1 setSubTitle(int resId){
        mActionbar.setSubtitle(resId);
        return this;
    }

    public ToolBar1 setNavigationOnClickListener(View.OnClickListener listener){
        mToolbar.setNavigationOnClickListener(listener);
        return this;
    }

    public ToolBar1 setNavigationIcon(int resId){
        mToolbar.setNavigationIcon(resId);
        return this;
    }

    public ToolBar1 setDisplayHomeAsUpEnabled(boolean show){
        mActionbar.setDisplayHomeAsUpEnabled(show);
        return this;
    }

    public ToolBar1 setCustomView(View view){
        rlCustom.removeAllViews();
        rlCustom.addView(view);
        return this;
    }

}
