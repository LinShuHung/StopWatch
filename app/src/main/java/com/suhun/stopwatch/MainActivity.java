package com.suhun.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.suhun.stopwatch.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}