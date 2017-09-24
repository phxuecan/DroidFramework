package com.leehq.sample.glide;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.leehq.retrofit.R;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class FirstGlideActivity extends Activity
{
    private ImageView mImageView;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_glide_activity);
        mImageView = (ImageView) findViewById(R.id.imageview);
        Glide.with(this).load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
        .into(mImageView);
    }
}
