package com.suhun.stopwatch;

import android.content.Context;

import com.suhun.stopwatch.databinding.ActivityMainBinding;

import java.util.Timer;

public class StopWatch {
    public String tag = StopWatch.class.getSimpleName();
    private ActivityMainBinding binding;
    private Context context;
    private boolean isStart;
    private Timer timer;

    public StopWatch(Context context, ActivityMainBinding binding){
        this.context = context;
        this.binding = binding;
        this.timer = new Timer();
    }

    public void doLeft(){

    }

    public void doRight(){
        isStart = !isStart;
        if(isStart){
            doStart();
        }else{
            doStop();
        }
    }

    private void doStart() {
        binding.leftBtn.setText("Lap");
        binding.rightBtn.setText("Stop");
    }

    private void doStop(){
        binding.leftBtn.setText("Reset");
        binding.rightBtn.setText("Start");
    }
}
