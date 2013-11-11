package il.ac.shenkar.DO2;

/**
 * Created by BNP on 04/11/13.
 */



public class ItemDetails {
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    private String name;

    public ItemDetails(String name){
        this.name=name;
    }
}


