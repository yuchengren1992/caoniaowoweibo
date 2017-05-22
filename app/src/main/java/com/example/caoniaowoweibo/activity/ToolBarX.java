package com.example.caoniaowoweibo.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.caoniaowoweibo.R;

/**
 * Created by Administrator on 2017/5/22.
 */

public class ToolBarX {
    private Toolbar mToolbar;
    private AppCompatActivity mActivity;
    private ActionBar mActionbar;
    private RelativeLayout rlCustom;

    public ToolBarX(Toolbar Toolbar, final AppCompatActivity Activity) {
        this.mToolbar =Toolbar;
        this.rlCustom=(RelativeLayout)mToolbar.findViewById(R.id.rlCustom);
        this.mActivity = Activity;
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

    public ToolBarX setNavigationOnClickListener(View.OnClickListener listener){
        mToolbar.setNavigationOnClickListener(listener);
        return this;
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

}
