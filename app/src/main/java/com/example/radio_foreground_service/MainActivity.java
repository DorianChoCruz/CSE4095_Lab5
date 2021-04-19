package com.example.radio_foreground_service;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.radio_foreground_service.service.RadioService;

import com.example.radio_foreground_service.ui.player.PlayerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static com.example.radio_foreground_service.ui.radio.RadioFragment.currRadio;

public class MainActivity extends AppCompatActivity {
    public static final String NOTIFICATION_CHANNEL_ID = "109";
    public String radioTitle;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        if (currRadio == null) {
            radioTitle = "Chill";
        } else {
            radioTitle = currRadio.getRadioName();
        }


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_radio, R.id.navigation_player)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }



    public void startService(View v){
        Intent serviceIntent= new Intent(this, RadioService.class);
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    public void stopService(View v){
        Intent serviceIntent= new Intent(this, RadioService.class);
        stopService(serviceIntent);
    }


}