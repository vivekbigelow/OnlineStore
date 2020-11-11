package client;

import java.rmi.Naming;
import java.util.Scanner;
<<<<<<< HEAD
=======
import account.AccountManager;
import account.User;
import account.Admin;
>>>>>>> f364014f29690d75635c69b3ced5d447402999a2


public class Client{
    public static void main(String args[]) {
        try{
            
            String name = "//in-csci-rrpc06:2323/Remote";
            //AccountManager manager = (AccountManager)Naming.lookup(name);

            System.out.println("Found Server Object");
<<<<<<< HEAD
          

            System.out.println("Would you like to Register a new account? y or n");

            answer = readObj.nextLine().trim().toLowerCase();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

        //     if(answer.equals("y")){
        //         //show register dialogue
        //         showRegistrationDialogue(manager);
        //     }else if (answer.equals("n")){
        //         //show login dialogue
        //     }else{
        //         System.out.println("Incorrect response");
        //     }

        //     readObj.close();
=======
            Scanner readObj = new Scanner(System.in);

            dialogueLoop(manager,readObj);
>>>>>>> f364014f29690d75635c69b3ced5d447402999a2


        // }catch(Exception e){
        //     System.out.println(e.getMessage());
        // }

       
    

<<<<<<< HEAD
    // public static void showRegistrationDialogue(AccountManager manager){
    //     Scanner readObj = new Scanner(System.in);
=======
    public static void showRegistrationDialogue(AccountManager manager,Scanner readObj){
       // Scanner readObj = new Scanner(System.in);
        
>>>>>>> f364014f29690d75635c69b3ced5d447402999a2

    //     System.out.println("Enter an account type, either user or admin");
    //     String accountType = readObj.nextLine().trim().toLowerCase();
    //     System.out.println("Enter your username");
    //     String username = readObj.nextLine().trim().toLowerCase();
    //     System.out.println("Enter your password");
    //     String password = readObj.nextLine().trim().toLowerCase();

    //     if (accountType.equals("user")){
    //         try{
    //             manager.registerUser(username, password);
                
<<<<<<< HEAD
    //             if(manager.getUser(username, password) != null){
    //                 System.out.println("Your account was created successfully");
    //             }else{
    //                 System.out.println("There was a problem creating your account");
    //             }
            
    //         }catch(Exception e){
    //             System.out.println(e.getMessage());
    //         }
    //     }else if (accountType.equals("admin")){
    //         try{
    //             manager.registerAdmin(username, password);

    //             if(manager.getAdmin(username, password) != null){
    //                 System.out.println("Your account was created successfully");
    //                 readObj.close();
    //             }else{
    //                 System.out.println("There was a problem creating your account");
    //                 readObj.close();
    //             }
    //         }catch(Exception e){
    //             System.out.println(e.getMessage());
    //         }
    //     }else{
    //         System.out.println("Account type "+accountType+" unavailable");
    //         readObj.close();

    //         showRegistrationDialogue(manager);
    //     }
    // }
=======
                if(manager.getUser(username, password) != null){
                    System.out.println("Your account was created successfully");
                    //readObj.close();
                    showLoginDialogue(manager,readObj);
                }else{
                    System.out.println("There was a problem creating your account");
                    //readObj.close();
                    dialogueLoop(manager,readObj);
                }
            
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else if (accountType.equals("admin")){
            try{
                manager.registerAdmin(username, password);

                if(manager.getAdmin(username, password) != null){
                    System.out.println("Your account was created successfully");
                    //readObj.close();
                    showLoginDialogue(manager,readObj);
                }else{
                    System.out.println("There was a problem creating your account");
                    //readObj.close();
                    dialogueLoop(manager,readObj);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Account type "+accountType+" unavailable");
            //readObj.close();

            dialogueLoop(manager,readObj);
        }

        
    }

    public static void showLoginDialogue(AccountManager manager, Scanner readObj){
        //Scanner readObj = new Scanner(System.in);

        System.out.println("To login enter an account type, either user or admin");
        String accountType = readObj.nextLine().trim().toLowerCase();
        System.out.println("Enter your username");
        String username = readObj.nextLine().trim().toLowerCase();
        System.out.println("Enter your password");
        String password = readObj.nextLine().trim().toLowerCase();

        if (accountType.equals("user")){
            try{
                if(manager.getUser(username, password) != null){
                    System.out.println("Welcome "+username+" login was successful");
                    User user = manager.getUser(username,password);
                    //readObj.close();
                    userDialogue(manager, user, readObj);
                }else{
                    System.out.println("No account with those credentials");
                    //readObj.close();
                    dialogueLoop(manager, readObj);
                }
            
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else if (accountType.equals("admin")){
            try{
                if(manager.getAdmin(username, password) != null){
                    System.out.println("Welcome "+username+" login was successful");
                    readObj.close();
                    //show admin dialogue
                }else{
                    System.out.println("No account with those credentials");
                    //readObj.close();
                    dialogueLoop(manager,readObj);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Account type "+accountType+" unavailable");
            //readObj.close();

            dialogueLoop(manager,readObj);
        }


    }

    public static void userDialogue(AccountManager manager, User user, Scanner readObj){
        try{
            //Scanner readObj = new Scanner(System.in);

            System.out.println("Welcome to the store. What would you like to do (type commands not in parenthesis)? browse, add (to cart), view (cart), purchase, leave");
            String input = readObj.nextLine().trim().toLowerCase();
            if(input.equals("browse")){
                
                System.out.println(manager.getStore().browseItems());
                //readObj.close();
                userDialogue(manager,user,readObj);
                
            }else if(input.equals("add")){
                
                System.out.println("Enter the item code you would like to add to your cart.");
                String code = readObj.nextLine().trim().toLowerCase();
            
                if(manager.getStore().validItemCode(code)){
                    int storeQuantity = manager.getStore().getItem(code).getQuantity();
                    System.out.println("There are "+storeQuantity+" in stock");
                    System.out.println("Enter the quantity you want");
                    int quantity = Integer.parseInt(readObj.nextLine());
                    
                    if(quantity <= storeQuantity){
                        user.getCart().addItem(manager.getStore().getItem(code).getItem(),quantity);
                        manager.getStore().removeItem(code, quantity);
                        System.out.println(manager.getStore().getItem(code).getQuantity());
                        System.out.println("Item(s) were added to your cart");
                        userDialogue(manager,user,readObj);
                    }else{
                        System.out.println("There are not enough "+manager.getStore().getItem(code).getItem().getName()+" in stock");
                        //readObj.close();
                        userDialogue(manager,user,readObj);
                    }
                }else{
                    System.out.println("Invalid item code");
                    //readObj.close();
                    userDialogue(manager,user,readObj);
                }
            }else if(input.equals("view")){
                System.out.println(user.getCart().view());
                //readObj.close();
                userDialogue(manager, user,readObj);
            }else if(input.equals("purchase")){
                user.getCart().calculateTotal();
                System.out.println("Your total is "+user.getCart().getTotal());
                System.out.println("Thank you for your order");
                user.getCart().empty();
                //readObj.close();
                userDialogue(manager, user,readObj);
            }else if (input.equals("leave")){
                System.out.println("Goodbye");
                
            }
        }catch (Exception e){
        System.out.println(e.getMessage());
        }
    }

    
    public static void dialogueLoop(AccountManager manager, Scanner readObj){
       
            //Scanner readObj = new Scanner(System.in);
            String input;
            System.out.println("Would you like to register a new account? y or n");

            input = readObj.nextLine().trim().toLowerCase();

            if(input.equals("y")){
            //show register dialogue
            showRegistrationDialogue(manager,readObj);
            }else if (input.equals("n")){
            //show login dialogue
            showLoginDialogue(manager,readObj);
            }else{
            System.out.println("Invalid response");
            }
        
    }
>>>>>>> f364014f29690d75635c69b3ced5d447402999a2
}