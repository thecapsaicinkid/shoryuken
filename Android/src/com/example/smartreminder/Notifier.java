package com.example.smartreminder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class Notifier
{
	public void Notify(Context context, String message, int reminderId)
	{
		Notification notification = createNotification(context, message, reminderId);

		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		notificationManager.notify(reminderId, notification);
	}
	
	private Notification createNotification(Context context, String message, int reminderId)
	{
		Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Intent disableIntent = new Intent(context, ReminderDisableService.class)
                .setAction("DISABLE")
                .setData(Uri.parse("id://" + reminderId));

        PendingIntent disablePendingIntent = PendingIntent.getService(context, 0, disableIntent, 0);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(message)
                        .setContentText("SmartReminder")
                        .setDefaults(Notification.PRIORITY_HIGH)// requires VIBRATE permission
                         .setSound(sound)
                        .setStyle(
                                new NotificationCompat
                                        .BigTextStyle()
                                        .bigText(message))
                        .addAction(R.drawable.ic_launcher, "Disable", disablePendingIntent);

		return builder.build();
	}
}
