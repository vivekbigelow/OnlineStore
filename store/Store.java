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

    public ItemContainer getItem(String itemCode){
        ItemContainer container = null;
        for(int i = 0; i < this.items.size(); i++){
            ItemContainer stockContainer = this.items.get(i);
            Item stockItem = stockContainer.getItem();
            if(stockItem.getItemCode().equals(itemCode)){
                container = stockContainer;
            }
        }

        return container;
    }

    public String browseItems(){
        String result = "";
        if(this.items.size() == 0){
            result = "No items in stock";
        }else{
            for (int i = 0; i < this.items.size(); i++){
                ItemContainer stockItemContainer = this.items.get(i);
                Item stockItem = stockItemContainer.getItem();
                int quantity = stockItemContainer.getQuantity();
                result = result+"Item: "+stockItem.getName()+" Quantity: "+quantity+" Cost "+stockItem.getCost()+" Code: "+stockItem.getItemCode()+"\n";
            } 
        }

        return result;
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

    public void removeItem(String itemCode, int quantity){
        for (int i = 0; i < this.items.size(); i++){
            Item stockItem = this.items.get(i).getItem();
            if (stockItem.getItemCode().equals(itemCode)){
                try{
                    this.items.get(i).subtractItems(quantity);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
               
            }
        }
    }

    public Boolean validItemCode(String code){
        Boolean result = false;
        for(int i = 0; i < this.items.size(); i++){
            ItemContainer container = this.items.get(i);
            Item item = container.getItem();
            String itemCode = item.getItemCode();
            if(itemCode.equals(code)){
                result = true;
            }
        }
        return result;
    }
}