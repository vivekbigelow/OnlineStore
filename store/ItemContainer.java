package store;

import java.io.Serializable;

public class ItemContainer implements Serializable {
    private Item item;
    private int quantity;

    public ItemContainer(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public ItemContainer(ItemContainer itemContainer){
        this.item = itemContainer.getItem();
        this.quantity = itemContainer.getQuantity();
    }

    public Item getItem(){
        return this.item;
    }

    public void setItem(Item newItem){
        this.item = newItem;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }

    public void addItem(){
        this.quantity += 1;
    }

    public void addMultipleItems(int amount){
        this.quantity += amount;
    }

    public void subtractItems(int amount) throws LessThanZeroQuantityException {
        
        if ((this.quantity - amount) < 0){
            throw new LessThanZeroQuantityException("Cannot have less than zero items in quantity");
        }else{
            this.quantity -= amount;
        }
    }
}