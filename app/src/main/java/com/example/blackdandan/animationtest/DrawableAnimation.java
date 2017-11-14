package com.example.blackdandan.animationtest;

import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawableAnimation extends AppCompatActivity {
    /*Views*/
    private SeekBar mDurationSeekBar;
    private GridView mDrawableGridList;
    private ImageView mAnimationView;
    /*Data*/
    private List<String > mDrawablePathList = new ArrayList<>();
    /*时间间隔SeekBarListener*/
    private SeekBar.OnSeekBarChangeListener mOnDurationSeekBarChangeListener =new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            DebugUtil.print("DrawableAnimation.onProgressChanged");
            generateDrawableAnimation(null);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            DebugUtil.print("DrawableAnimation.onStartTrackingTouch");
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DebugUtil.print("DrawableAnimation.onStopTrackingTouch");
        }
    };
    /*GridViewAdapter*/
    private DrawableGridViewAdapter mGridViewAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);
        initView();
        initData();
    }


    private void initView(){
        mDurationSeekBar = (SeekBar) findViewById(R.id.sb_duration);
        mDurationSeekBar.setOnSeekBarChangeListener(mOnDurationSeekBarChangeListener);
        mDurationSeekBar.setMax(10);
        mDrawableGridList = (GridView) findViewById(R.id.gv_drawable_list);
        mAnimationView = (ImageView) findViewById(R.id.img_animation);

    }
    private void initData(){
        mDrawablePathList.add("/sdcard/a_1.png");
        mDrawablePathList.add("/sdcard/a_2.png");
        mDrawablePathList.add("/sdcard/a_3.png");
        mGridViewAdapter = new DrawableGridViewAdapter(this,mDrawablePathList);
        mDrawableGridList.setAdapter(mGridViewAdapter);
    }

    public void generateDrawableAnimation(View view) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        if (mDrawablePathList.size()==0)return;
        int duration = mDurationSeekBar.getProgress()*1000/mDrawablePathList.size();

        DebugUtil.print(duration+"");
        for (int i = 0;i<mDrawablePathList.size();i++) {
            animationDrawable.addFrame(Drawable.createFromPath(mDrawablePathList.get(i)),duration);
        }
        mDrawableGridList.setVisibility(View.GONE);
        mAnimationView.setVisibility(View.VISIBLE);
        mAnimationView.setImageBitmap(BitmapFactory.decodeFile(mDrawablePathList.get(0)));
        mAnimationView.setImageDrawable(animationDrawable);
        animationDrawable.setOneShot(false);
        animationDrawable.start();
    }
}
