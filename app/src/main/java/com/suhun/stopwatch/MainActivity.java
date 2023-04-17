package com.suhun.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.suhun.stopwatch.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;
    private StopWatch stopWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        stopWatch = new StopWatch(this, binding);
    }

    public void leftFButton(View view){

    }

    public void rightButton(View view){
        stopWatch.doRight();
    }

    public void exitButton(View view){

    }
}