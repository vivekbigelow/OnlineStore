package account;

import store.Store;
import store.Cart;

public class AccountCreator{
    Store store;

    AccountCreator(Store store){
        this.store = store;
    }

    public User createUser(String username, String password){
       
        Cart newCart = new Cart();
        User newUser = new User(username,password,this.store,newCart);

        return newUser;
    }

    public Admin createAdmin(String username, String password){
        
        Admin newAdmin = new Admin(username,password,this.store);
        
        return newAdmin;
    }
}