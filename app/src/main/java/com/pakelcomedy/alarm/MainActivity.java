package com.pakelcomedy.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends Activity {
    private TimePicker timePicker;
    private Button setAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker);
        setAlarmButton = findViewById(R.id.setAlarmButton);

        setAlarmButton.setOnClickListener(v -> {
            int hour = timePicker.getCurrentHour();
            int minute = timePicker.getCurrentMinute();

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

            alarmManager.set(AlarmManager.RTC_WAKEUP, getTimeInMillis(hour, minute), pendingIntent);
        });
    }

    private long getTimeInMillis(int hour, int minute) {
        // Convert hour and minute to milliseconds for AlarmManager
        return System.currentTimeMillis() + (hour * 3600 * 1000) + (minute * 60 * 1000);
    }
}
