package OnlineStoreModel;

import store.Store;
import account.AccountCreator;
import account.User;
import account.Admin;
import java.util.ArrayList;

public class OnlineStoreModel{
    Store store;
    AccountCreator accountCreator;
    ArrayList<User> users;
    ArrayList<Admin> admins;

    public OnlineStoreModel(Store store){
        this.store = store;
        this.accountCreator = new AccountCreator(this.store);
        this.users = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    public Store getStore(){
        return this.store;
    }

    public AccountCreator getAccountCreator(){
        return this.accountCreator;
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }

    public ArrayList<Admin> getAdmins(){
        return this.admins;
    }

    public void registerUser(String username, String password){
        User newUser = this.accountCreator.createUser(username, password);
        this.users.add(newUser);

        System.out.println("New user "+username+" created");
    }

    public void registerAdmin(String username, String password){
        Admin newAdmin = this.accountCreator.createAdmin(username, password);
        this.admins.add(newAdmin);
        
        System.out.println("New admin "+username+" created");
    }

    public User getUser(String username, String password){
        User user;
        for (int i = 0; i < this.users.size(); i++){
            user = this.users.get(i);
            if (user.getUserName().equals(username) && user.getPassword().equals(password)){
                return user;
            }else{
                continue;
            }
        }
        user = null;
        return user;
    }

    public Admin getAdmin(String username, String password){
        Admin admin = null;
        for (int i = 0; i < this.admins.size(); i++){
            admin = this.admins.get(i);
            if (admin.getUserName().equals(username) && admin.getPassword().equals(password)){
                return admin;
            }else{
                continue;
            }
        }
        admin = null;
        return admin;
    }
}