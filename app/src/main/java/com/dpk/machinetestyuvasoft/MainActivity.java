package com.dpk.machinetestyuvasoft;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void defaultRing(View v) {
        Intent intent = new Intent(getApplicationContext(), DefaultNotificationRingService.class);
        ContextCompat.startForegroundService(getApplicationContext(), intent);
    }

    public void customRing(View v) {
        Intent intent = new Intent(getApplicationContext(), CustomNotificationRingServices.class);
        ContextCompat.startForegroundService(getApplicationContext(), intent);
    }
}
