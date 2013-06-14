package com.example.smartreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class EventActioner extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
        new ReminderTask(context.getApplicationContext()).execute(intent);
	}
}