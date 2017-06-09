package com.leehq.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.leehq.retrofit.R;

/**
 * Created by putao_lhq on 17-6-8.
 */

public class ConstraintActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constaint_activity);
    }
}
