package store;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private double cost;
    private String itemCode;

    public Item(String name,double cost,String itemCode){
        this.name = name;
        this.cost = cost;
        this.itemCode = itemCode;
    }

    public Item(Item item){
        this.name = item.getName();
        this.cost = item.getCost();
        this.itemCode = item.getItemCode();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public double getCost(){
        return this.cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public String getItemCode(){
        return this.itemCode;
    }

    public void setItemCode(String newCode){
        this.itemCode = newCode;
    }
}