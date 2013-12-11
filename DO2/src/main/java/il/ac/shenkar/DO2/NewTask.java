package il.ac.shenkar.DO2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * Created by BNP on 04/11/13.
 */
public class NewTask extends Activity {
        public static DatabaseHandler DB;
        public static int id=1;
        @SuppressLint("NewApi")
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                DB=DatabaseHandler.getInstance(this);
                setContentView(R.layout.new_task);
            }

        public boolean onOptionsItemsSelected(MenuItem item){
            switch (item.getItemId()){
                case android.R.id.home:
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

    public void createTask(View view){
        EditText editText=(EditText) findViewById(R.id.new_task);
        if (editText.getText().toString().isEmpty()) return;
        // String task=editText.getText().toString();
        ItemDetails task=new ItemDetails(editText.getText().toString());
        task.setID(id);
        DB.addTask(task);
        editText.setText("");

        Intent intent = new Intent("il.ac.shenkar.DO2");
        intent.putExtra("Message",task.getName());
        intent.putExtra("ID",id);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, id++, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, pendingIntent);

        finish();
    }

    public void cancel(View view){
          finish();
    }
}
