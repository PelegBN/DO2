package il.ac.shenkar.DO2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by BNP on 11/12/13.
 */
public class ReminderBroadcastReceiver extends BroadcastReceiver {
    //public static int id=1;
    public void onReceive (Context context, Intent intent){

        Intent myIntent = new Intent(context, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, intent.getIntExtra("ID",0) , myIntent, 0);
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new Notification(R.drawable.ic_launcher, "iDO[2]", System.currentTimeMillis());
        notification.setLatestEventInfo(context,intent.getStringExtra("Message"), "iDO[2]", pendingIntent);
        notificationManager.notify(intent.getIntExtra("ID",0), notification); //0 is id

    }

}
