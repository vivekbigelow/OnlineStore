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

    public String view(){
        String result = "";
        if (this.items.size() > 0){
            for (int i = 0; i < this.items.size(); i++){
                ItemContainer container = this.items.get(i);
                Item item = container.getItem();
                int quantity = container.getQuantity();
                String code = item.getItemCode();
                result = result+"Item: "+item.getName()+" Quantity: "+quantity+" Code: "+code+"\n";
            }
        }else{
            result = "Your cart is empty";
        }
        this.calculateTotal();
        return result+"\nTotal cost "+this.getTotal();
    }

    public void addItem(Item item, int quantity){
        Boolean added = false;
        //in case the item is already in the store
        for (int i = 0; i < this.items.size(); i++){
            Item cartItem = this.items.get(i).getItem();
            String cartCode = cartItem.getItemCode();
            if (cartCode.equals(item.getItemCode())){
                this.items.get(i).addMultipleItems(quantity);
                added = true;
            }
        }
        //if the item is new
        if(!added){
            ItemContainer newItem = new ItemContainer(item, quantity);
            items.add(newItem);
        }

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

    public void empty(){
        this.items.clear();
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