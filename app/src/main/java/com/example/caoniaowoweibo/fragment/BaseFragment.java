package com.example.caoniaowoweibo.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.caoniaowoweibo.R;

/**
 * Created by Administrator on 2017/5/21.
 */

public class BaseFragment extends Fragment {
    @Override
    public void startActivity(Intent intent) {
//      super.startActivity(intent);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.anim_in_right_left,R.anim.anim_out_right_left);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
//      super.startActivityForResult(intent,requestCode);
        getActivity().startActivityForResult(intent,requestCode);
        getActivity().overridePendingTransition(R.anim.anim_in_right_left,R.anim.anim_out_right_left);
    }
}
