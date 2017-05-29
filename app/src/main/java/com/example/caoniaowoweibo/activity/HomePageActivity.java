package com.example.caoniaowoweibo.activity;

import android.hardware.camera2.params.RggbChannelVector;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;


import com.example.caoniaowoweibo.R;
import com.example.caoniaowoweibo.fragment.HomeFragment;
import com.example.caoniaowoweibo.fragment.MessageFragment;
import com.example.caoniaowoweibo.fragment.ProfileFragment;

/**
 * Created by Administrator on 2017/5/24.
 */

public class HomePageActivity extends BaseActivity {
    private FrameLayout flContainer;
    private FragmentTabHost tabHost;
    private FragmentManager fragmentManager;
    private RadioButton rbHome;
    private RadioButton rbMessage;
    private RadioButton rbProfile;
    private RadioGroup rgTab;
    private Class fragment[];
    private int menu_id=R.menu.menu_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolBar().setDisplayHomeAsUpEnabled(false)
                .setTitle(R.string.app_name);
//        setContentView(R.layout.ac_home_page);
        fragment = new Class[]{HomeFragment.class, MessageFragment.class, ProfileFragment.class};
        //碎片数组
        flContainer = (FrameLayout) findViewById(R.id.rlContainer);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);//原生id

        rgTab = (RadioGroup) findViewById(R.id.rgTab);
        rbMessage = (RadioButton) findViewById(R.id.rlMessage);
        rbHome = (RadioButton) findViewById(R.id.rlHome);
        rbProfile = (RadioButton) findViewById(R.id.rlProfile);
        //初始化组件

        fragmentManager=getSupportFragmentManager();
        tabHost.setup(getApplicationContext(), fragmentManager, R.id.rlContainer);

        for (int i = 0; i < fragment.length; i++) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(String.valueOf(i)).setIndicator(String.valueOf(i));
            tabHost.addTab(tabSpec, fragment[i], null);
        }
        tabHost.setCurrentTab(0);
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rlHome:
                        tabHost.setCurrentTab(0);
                        menu_id=R.menu.menu_home;
                        break;
                    case R.id.rlMessage:
                        tabHost.setCurrentTab(1);
                        menu_id=-1;
                        break;
                    case R.id.rlProfile:
                        tabHost.setCurrentTab(2);
                        menu_id=-1;
                        break;
                }
                supportInvalidateOptionsMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu_id==-1){
            menu.clear();
        }else{
            getMenuInflater().inflate(menu_id,menu);
        }
//        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.ac_home_page;
    }
}
