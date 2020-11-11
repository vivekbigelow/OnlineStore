package account;

import store.Store;
import java.io.Serializable;

abstract class Account implements Serializable  {
    String username;
    String password;
    Store store;

    Account(String username, String password, Store store){
        this.username = username;
        this.password = password;
        this.store = store;
    }

    public String getUserName(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public Store getStore(){
        return this.store;
    }

    public void setUserName(String newName){
        this.username = newName;
    }

    public void setPassword(String newPass){
        this.password = newPass;
    }

    public void setStore(Store newStore){
        this.store = newStore;
    }
}
