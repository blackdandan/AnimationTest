package com.example.blackdandan.animationtest;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ViewAnimationActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private TextView startXMin;
    private TextView startXMax;
    private TextView startYMin;
    private TextView startYMax;
    private TextView endYMin;
    private TextView endYMax;
    private TextView endXMin;
    private TextView endXMax;
    private SeekBar startXSeekBar;
    private SeekBar startYSeekBar;
    private SeekBar endXSeekBar;
    private SeekBar endYSeekBar;
    private SeekBar durationSeekBar;
    private Point point = new Point();//屏幕大小
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        DebugUtil.print("window:"+getWindow());
        DebugUtil.print("windowManager:"+getWindow().getWindowManager());
        DebugUtil.print("windowManager.getDefaultDisplay;:"+getWindow().getWindowManager().getDefaultDisplay());
        initView();
        initValue();

    }

    private void initValue() {
        getWindow().getWindowManager().getDefaultDisplay().getSize(point);
        DebugUtil.print("x:"+point.x);
        DebugUtil.print("y:"+point.y);
        startXMin.setText(0+"");
        startYMin.setText(0+"");
        endYMin.setText(0+"");
        endXMin.setText(0+"");
        startYMax.setText(point.y+"");
        endYMax.setText(point.y+"");
        startXMax.setText(point.x+"");
        endXMax.setText(point.x+"");
        startXSeekBar.setMax(point.x);
        startYSeekBar.setMax(point.y);
        endXSeekBar.setMax(point.x);
        endYSeekBar.setMax(point.y);
        durationSeekBar.setMax(3000);
    }

    private void initView() {
        startXMin = (TextView) findViewById(R.id.tv_translate_start_x_min);
        startXMax = (TextView) findViewById(R.id.tv_translate_start_x_max);
        startYMin = (TextView) findViewById(R.id.tv_translate_start_y_min);
        startYMax = (TextView) findViewById(R.id.tv_translate_start_y_max);
        endYMin = (TextView) findViewById(R.id.tv_translate_end_y_min);
        endYMax = (TextView) findViewById(R.id.tv_translate_end_y_max);
        endXMax = (TextView) findViewById(R.id.tv_translate_end_x_max);
        endXMin = (TextView) findViewById(R.id.tv_translate_end_x_min);
        startXSeekBar = (SeekBar) findViewById(R.id.sb_translate_start_x);
        startYSeekBar = (SeekBar) findViewById(R.id.sb_translate_start_y);
        endXSeekBar = (SeekBar) findViewById(R.id.sb_translate_end_x);
        endYSeekBar = (SeekBar) findViewById(R.id.sb_translate_end_y);
        durationSeekBar = (SeekBar) findViewById(R.id.sb_duration);
        imageView = (ImageView) findViewById(R.id.img_animation);

    }

    public void startAnimation(View view) {
        TranslateAnimation scaleAnimation = new TranslateAnimation(Animation.ABSOLUTE,(float) startXSeekBar.getProgress()
                ,Animation.ABSOLUTE,(float)endXSeekBar.getProgress ()
                ,Animation.ABSOLUTE,(float) startYSeekBar.getProgress()
                ,Animation.ABSOLUTE,(float)endYSeekBar.getProgress());
        scaleAnimation.setDuration(durationSeekBar.getProgress());
        scaleAnimation.setRepeatCount(10);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        imageView.startAnimation(scaleAnimation);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        startAnimation(null);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
