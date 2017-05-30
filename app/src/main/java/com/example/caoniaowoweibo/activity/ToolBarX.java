package com.example.caoniaowoweibo.activity;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.caoniaowoweibo.R;

import static android.content.ContentValues.TAG;


/**
 * Created by Administrator on 2017/5/24.
 */

public class ToolBarX {
    private Toolbar mToolbar;
    private AppCompatActivity mActivity;
    private ActionBar mActionbar;
    private RelativeLayout rlCustom;

    public ToolBarX(Toolbar toolbar,AppCompatActivity activity) {
        mToolbar =toolbar;
        mActivity =activity;
        rlCustom=(RelativeLayout)mToolbar.findViewById(R.id.rlCustom);
        mActivity.setSupportActionBar(mToolbar);
        mActionbar=mActivity.getSupportActionBar();
        mActionbar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mActivity.finish();
            }
        });
    }

    public ToolBarX setTitle(String text){
        mActionbar.setTitle(text);
        return this;
    }

    public ToolBarX setSubTitle(String text){
        mActionbar.setSubtitle(text);
        return this;
    }

    public ToolBarX setTitle(int resId){
        mActionbar.setTitle(resId);
        return this;
    }

    public ToolBarX setSubTitle(int resId){
        mActionbar.setSubtitle(resId);
        return this;
    }

    public void setNavigationOnClickListener(View.OnClickListener listener){
        mToolbar.setNavigationOnClickListener(listener);
//        return this;
    }

    public ToolBarX setNavigationIcon(int resId){
        mToolbar.setNavigationIcon(resId);
        return this;
    }

    public ToolBarX setDisplayHomeAsUpEnabled(boolean show){
        mActionbar.setDisplayHomeAsUpEnabled(show);
        return this;
    }

    public ToolBarX setCustomView(View view){
        rlCustom.removeAllViews();
        rlCustom.addView(view);
        return this;
    }

    public ToolBarX hide(){
        mActionbar.hide();
        return this;
    }

}
