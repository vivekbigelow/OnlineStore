package remote;

import java.rmi.*;
import java.rmi.registry.*;


import store.Item;
import store.ItemContainer;
import store.Store;



public class OnlineStore{
    
    public static void main(String args[]){
        Item book = new Item("book", 20.0, "1b");
        ItemContainer bookContainer = new ItemContainer(book, 15);

        Item shoe = new Item("shoe", 50.0, "2s");
        ItemContainer shoeContainer = new ItemContainer(shoe,10);

        Item game = new Item("game", 15.0,"3g");
        ItemContainer gameContainer = new ItemContainer(game,10);


        Store store = new Store();

        store.addItem(bookContainer);
        store.addItem(shoeContainer);
        store.addItem(gameContainer);

        try{
            
            String name ="//in-csci-rrpc06:2323/Remote";
            //Naming.rebind(name,accountManager);

            System.out.println("Server is ready");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
