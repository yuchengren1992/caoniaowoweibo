package com.example.caoniaowoweibo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.caoniaowoweibo.R;

import java.io.ByteArrayInputStream;

/**
 * Created by Administrator on 2017/5/15.
 */

public class FirstActivity extends BaseActivity {
    private Button testButton;
//    private Toolbar toolbar;//-
    private ToolBarX toolBarX;//+
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.first_layout);//-
//        toolbar=(Toolbar)findViewById(R.id.toolBar);
        testButton=(Button)findViewById(R.id.testbutton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
//        toolBarX=getToolBar();
//        toolBarX.setTitle(R.string.title_first).setSubTitle(R.string.title_sub_first);
        getToolBar().setDisplayHomeAsUpEnabled(true).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).setTitle("ToolBar").setSubTitle("XSub");

//      setSupportActionBar(toolbar);
//        toolbar.setTitle(R.string.title_first);
//        toolbar.setSubtitle(R.string.title_sub_first);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("TAG","setNavigationOnClickListener");
//            }
//        });


////        toolbar.inflateMenu(R.menu.menu_main);
////        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
////            @Override
////            public boolean onMenuItemClick(MenuItem item) {
////                item.getItemId();
////                Log.e("TAG","setOnMenuItemClickListener");
////                return true;
////            }
////        });
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
////        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setTitle("setTitleActionBar");
//        //1 ToolBar的标题必须在setSupportActionBar之前设置
//        //2 当调用setSupportActionBar之后，ToolBar.inflateMenu()方法就失败
//        //3 ToolBar推荐和ActionBar一起是使用
    }

    @Override
    public int getLayoutId() {
        return R.layout.first_layout;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("TAG","setNavigationOnClickListener");
        return super.onOptionsItemSelected(item);
    }
    //    @Override
//    public int getLayoutId() {
//        return R.layout.first_layout;
//    }
}
