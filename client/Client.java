package client;

import java.rmi.Naming;
import java.util.Scanner;
import account.AccountManager;

public class Client{
    public static void main(String args[]) {
        try{
            Scanner readObj = new Scanner(System.in);
            String name = "//in-csci-rrpc06:2323/Remote";
            AccountManager manager = (AccountManager)Naming.lookup(name);

            String answer;

            System.out.println("Found Server Object");
          

            System.out.println("Would you like to Register a new account? y or n");

            answer = readObj.nextLine().trim().toLowerCase();

            if(answer.equals("y")){
                //show register dialogue
                showRegistrationDialogue(manager);
            }else if (answer.equals("n")){
                //show login dialogue
            }else{
                System.out.println("Incorrect response");
            }

            readObj.close();


        }catch(Exception e){
            System.out.println(e.getMessage());
        }

       
    }

    public static void showRegistrationDialogue(AccountManager manager){
        Scanner readObj = new Scanner(System.in);

        System.out.println("Enter an account type, either user or admin");
        String accountType = readObj.nextLine().trim().toLowerCase();
        System.out.println("Enter your username");
        String username = readObj.nextLine().trim().toLowerCase();
        System.out.println("Enter your password");
        String password = readObj.nextLine().trim().toLowerCase();

        if (accountType.equals("user")){
            try{
                manager.registerUser(username, password);
                
                if(manager.getUser(username, password) != null){
                    System.out.println("Your account was created successfully");
                }else{
                    System.out.println("There was a problem creating your account");
                }
            
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else if (accountType.equals("admin")){
            try{
                manager.registerAdmin(username, password);

                if(manager.getAdmin(username, password) != null){
                    System.out.println("Your account was created successfully");
                    readObj.close();
                }else{
                    System.out.println("There was a problem creating your account");
                    readObj.close();
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Account type "+accountType+" unavailable");
            readObj.close();

            showRegistrationDialogue(manager);
        }
    }
}