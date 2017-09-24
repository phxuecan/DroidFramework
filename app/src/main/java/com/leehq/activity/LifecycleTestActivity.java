package com.leehq.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.leehq.aroidframe.log.LogUtil;
import com.leehq.retrofit.R;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class LifecycleTestActivity extends Activity {

    private final String TAG = LifecycleTestActivity.class.getSimpleName();

    private EditText mEditText;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle_test_activity);
        mEditText = (EditText) findViewById(R.id.editText);
        LogUtil.i(TAG, "onCreate");
        LogUtil.i(TAG, "mEditText id is " + mEditText);
    }

    @Override
    protected void onRestart () {
        super.onRestart();
        LogUtil.i(TAG, "onRestart");
    }

    @Override
    protected void onStart () {
        super.onStart();
        LogUtil.i(TAG, "onStart");
    }

    @Override
    protected void onResume () {
        super.onResume();
        LogUtil.i(TAG, "onResume");
    }

    @Override
    protected void onPause () {
        super.onPause();
        LogUtil.i(TAG, "onPause");
    }

    @Override
    protected void onStop () {
        super.onStop();
        LogUtil.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        LogUtil.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState (Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.i(TAG, "onRestoreInstanceState：" + savedInstanceState);
    }
}
