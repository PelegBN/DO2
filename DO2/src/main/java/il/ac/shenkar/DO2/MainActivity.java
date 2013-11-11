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
    public static ListSingleton once;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        once=ListSingleton.getInstance(this);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listV_main);
        listView.setAdapter(new ItemListBaseAdapter(this, once.getItems()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ItemDetails selectedItem = (ItemDetails) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "You have chosen : " + " " +
                        selectedItem.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void createNew(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }

    public void done(View view){
        ListView listView = (ListView) findViewById(R.id.listV_main);
        int pos = listView.getPositionForView(view);

        once.removeTask(pos);
    }
}
