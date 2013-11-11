package il.ac.shenkar.DO2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * Created by BNP on 04/11/13.
 */
public class NewTask extends Activity {
        public static ListSingleton once;
        @SuppressLint("NewApi")
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                once=ListSingleton.getInstance(this);
                setContentView(R.layout.new_task);
            }

        public boolean onOptionsItemsSelected(MenuItem item){
            switch (item.getItemId()){
                case android.R.id.home:
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

    public void back(View view){
        EditText editText=(EditText) findViewById(R.id.new_task);
        if (editText.getText().toString().isEmpty()) return;
        String task=editText.getText().toString();
        once.addTask(task);
        editText.setText("");
        finish();
    }



    public void cancel(View view){
          finish();
    }
}
