package il.ac.shenkar.DO2;

/**
 * Created by BNP on 04/11/13.
 */

public class ItemDetails {

    private String name;
    private int ID;
    // private static int counter=0;


    public ItemDetails(String name){
        this.name=name;
     // ID=counter;
     // counter++;
    }

    public ItemDetails(int ID, String name){
        this.name=name;
        this.ID=ID;
    }

    public ItemDetails(){
    }

    public String getName(){
        return name;
    }

    public void setID(int ID){
        this.ID=ID;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getID(){
        return ID;
    }
}


