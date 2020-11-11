package store;

import java.util.ArrayList;
import java.io.Serializable;

public class Store implements Serializable {
    private ArrayList<ItemContainer> items;

    public Store(){
        this.items = new ArrayList<>();
    }

    public Store(Store store){
        this.items = store.getItems();
    }

    public ArrayList<ItemContainer> getItems(){
        return this.items;
    }

    public void browseItems(){
        if(this.items.size() == 0){
            System.out.println("No items in stock");
        }else{
            for (int i = 0; i < this.items.size(); i++){
                ItemContainer stockItemContainer = this.items.get(i);
                Item stockItem = stockItemContainer.getItem();
                int quantity = stockItemContainer.getQuantity();
                System.out.println("Item: "+stockItem.getName()+" Quantity: "+quantity+" Code: "+stockItem.getItemCode());
            } 
        }
    }

    public void addItem(ItemContainer item){
        Boolean added = false;
        //in case the item is already in the store
        for (int i = 0; i < this.items.size(); i++){
            Item stockItem = this.items.get(i).getItem();
            if (stockItem.getItemCode().equals(item.getItem().getItemCode())){
                items.get(i).addMultipleItems(item.getQuantity());
                added = true;
            }
        }
        //if the item is new
        if(!added){
            items.add(item);
        }

    }

    public void removeItem(Item item, int quantity){
        for (int i = 0; i < this.items.size(); i++){
            Item stockItem = this.items.get(i).getItem();
            if (stockItem.getItemCode().equals(item.getItemCode())){
                try{
                    this.items.get(i).subtractItems(quantity);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
               
            }
        }
    }
}