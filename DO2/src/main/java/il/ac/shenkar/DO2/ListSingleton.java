package il.ac.shenkar.DO2;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by BNP on 11/11/13.
 */
public class ListSingleton {

    private static ListSingleton instance = null;
    private ArrayList<ItemDetails> tasklist=new ArrayList<ItemDetails>();

    private Context context;
    private ListSingleton(Context context) {
        this.context = context;
    }

    public static synchronized ListSingleton getInstance(Context context) {
        if(instance == null) {
            instance = new ListSingleton(context);
        }
        return instance;
    }

    public void addTask(String task){
        ItemDetails obj = new ItemDetails(task);
        tasklist.add(obj);
    }

    public void removeTask(int position){
        tasklist.remove(position);
    }

    public ArrayList<ItemDetails> getItems(){


        return tasklist;
    }
}
