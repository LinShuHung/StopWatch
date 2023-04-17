package com.suhun.stopwatch;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.suhun.stopwatch.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
    public String tag = StopWatch.class.getSimpleName();
    private ActivityMainBinding binding;
    private Context context;
    private boolean isStart;
    private int counter;
    private Timer timer;
    private MyTask myTask;
    private UIHandler uiHandler;

    private class MyTask extends TimerTask{
        @Override
        public void run() {
            counter++;
            Log.d(tag, "Counter:" + counter);
            uiHandler.sendEmptyMessage(0);
        }
    }

    private class UIHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            binding.clock.setText(counterToClock(counter));
        }
    }

    private static String counterToClock(int counterTemp){
        int ms = counterTemp % 100;
        int ts = counterTemp / 100;
        int hh = ts / (60*60);
        int mm = (ts - hh*60*60) / 60;
        int ss = ts % 60;
        return String.format("%d:%d:%d.%d", hh, mm, ss, ms);
    }

    public StopWatch(Context context, ActivityMainBinding binding){
        this.context = context;
        this.binding = binding;
        this.timer = new Timer();
        this.uiHandler = new UIHandler();
        this.counter = 0;
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
        myTask = new MyTask();
        timer.schedule(myTask, 10, 10);
        binding.leftBtn.setText("Lap");
        binding.rightBtn.setText("Stop");
    }

    private void doStop(){
        if(myTask != null){
            myTask.cancel();
            myTask = null;
            counter = 0;
            binding.leftBtn.setText("Reset");
            binding.rightBtn.setText("Start");
        }
    }
}
