package account;

import java.rmi.*;
import java.util.ArrayList;

import store.Store;


public interface AccountManager extends Remote{
    public Store getStore() throws RemoteException;

    public AccountCreator getAccountCreator() throws RemoteException;

    public ArrayList<User> getUsers() throws RemoteException;

    public ArrayList<Admin> getAdmins() throws RemoteException;

    public void registerUser(String username, String password) throws RemoteException;

    public void registerAdmin(String username, String password) throws RemoteException;

    public User getUser(String username, String password) throws RemoteException;

    public Admin getAdmin(String username, String password) throws RemoteException;
}