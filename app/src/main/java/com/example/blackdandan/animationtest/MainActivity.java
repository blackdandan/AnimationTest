package com.example.blackdandan.animationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void drawableAnimation(View view) {
        Intent intent = new Intent(this,DrawableAnimation.class);
        startActivity(intent);
    }

    public void viewAnimation(View view) {
        Intent intent = new Intent(this,DrawableAnimation.class);
        startActivity(intent);
    }

    public void valueAnimation(View view) {
        Intent intent = new Intent(this,DrawableAnimation.class);
        startActivity(intent);
    }
}
