package store;

import java.io.Serializable;

import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<ItemContainer> items;
    private double total;

    public Cart(){
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public Cart(Cart cart){
        this.items = cart.getItems();
        this.total = cart.getTotal();
    }

    public ArrayList<ItemContainer> getItems(){
        return this.items;
    }

    public void setItems(ArrayList<ItemContainer> itemList){
        this.items = itemList;
    }

    public double getTotal(){
        return this.total;
    }

    public void removeItem(String itemCode){
        int removeIndex = -1;
        for(int i = 0; i < this.items.size(); i++){
            ItemContainer itemContainer = this.items.get(i);
            Item item = itemContainer.getItem();
            if(item.getItemCode().equals(itemCode)){
                removeIndex = i;
            }else{
                continue;
            }
        }
        if(removeIndex >= 0){
            this.items.remove(removeIndex);
        }else{
            System.out.println("Item not in cart");
        }
    }

    public void calculateTotal(){
        this.total = 0;
        if (this.items.size() == 0){
            this.total = 0;
        }else{
            for (int i = 0; i < this.items.size(); i++){
                ItemContainer itemContainer = this.items.get(i);
                Item item = itemContainer.getItem();
                int quantity = itemContainer.getQuantity();
                double cost = item.getCost() * quantity;
                this.total += cost;
            }
        }
    }
}