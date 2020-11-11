package account;

import store.Store;

public class Admin extends Account{
    Admin(String username, String password, Store store){
        super(username,password,store);
    }
}