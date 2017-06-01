package com.example.caoniaowoweibo.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.caoniaowoweibo.R;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

import static android.R.attr.data;

public class LoadingPageActivity extends BaseActivity {
    private SsoHandler mSssoHandler;
    private AuthInfo mAuthInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolBar().hide();//隐藏了登陆页面的ToolBar
        mAuthInfo = new AuthInfo(getApplicationContext(), CWConstant.APP_KEY,
                CWConstant.REDIRECT_URL, CWConstant.SCOPE);
        mSssoHandler = new SsoHandler(this, mAuthInfo);
        mSssoHandler.authorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                Log.e("onCreate", bundle + "");
            }

            @Override
            public void onWeiboException(WeiboException e) {

            }

            @Override
            public void onCancel() {

            }
        });
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(LoadingPageActivity.this,HomePageActivity.class));
//            }
//        },3000);
    }

        @Override
        public int getLayoutId () {
            return R.layout.activity_loading_page;
        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (mSssoHandler != null) {
                mSssoHandler.authorizeCallBack(requestCode, resultCode, data);
            }
        }
}
