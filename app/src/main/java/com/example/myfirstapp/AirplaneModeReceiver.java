package com.example.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (
                Settings.System.getInt(
                        context.getApplicationContext().getContentResolver(),
                        Settings.Global.AIRPLANE_MODE_ON, 0
                ) != 0
        ) {
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "AirPlane mode is off", Toast.LENGTH_SHORT).show();
        }
    }
}
