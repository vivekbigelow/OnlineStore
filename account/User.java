package account;

import java.util.ArrayList;
import store.Store;
import store.Cart;
import store.ItemContainer;

public class User extends Account{
   Cart cart;
   ArrayList<ItemContainer> orders;
    User(String username, String password, Store store, Cart cart){
        super(username,password,store);
        this.cart = cart;
        this.orders = new ArrayList<>();
    }

    public Cart getCart(){
        return this.cart;
    }
    public void setCart(Cart newCart){
        this.cart = newCart;
    }

    public ArrayList<ItemContainer> getOrders(){
        return this.orders;
    }

    public void setOrders(ArrayList<ItemContainer> newOrders){
        this.orders = newOrders;
    }
}