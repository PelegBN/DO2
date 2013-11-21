package il.ac.shenkar.DO2;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    public static DatabaseHandler DB;
    private ItemListBaseAdapter ILBA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DB=DatabaseHandler.getInstance(this);
        setContentView(R.layout.activity_main);

        updateListView();
        ILBA = new ItemListBaseAdapter(this, DB.getInstance(this).getAllTasks());

        final ListView listView = (ListView) findViewById(R.id.listV_main);
    }

    protected void onResume(){
        super.onResume();
        updateListView();
    }

    public void updateListView(){
        ListView lv = (ListView) findViewById(R.id.listV_main);
        ItemListBaseAdapter ILBA = new ItemListBaseAdapter(this, DB.getInstance(this).getAllTasks());
        lv.setAdapter(ILBA);
    }


    public void createNew(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }

    public void done(View view){
        ListView listView = (ListView) findViewById(R.id.listV_main);
        int pos = listView.getPositionForView(view);
        ItemDetails item = (ItemDetails) listView.getItemAtPosition(pos);
        DB.deleteTask(item);
        // ILBA.notifyDataSetChanged();
        updateListView();
    }
}
