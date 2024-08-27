package com.pakelcomedy.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // This will be executed when the alarm goes off
        Toast.makeText(context, "Alarm triggered!", Toast.LENGTH_SHORT).show();
    }
}
