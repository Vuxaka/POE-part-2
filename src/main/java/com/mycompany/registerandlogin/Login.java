/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerandlogin;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    
    /**
     * @param args the command line arguments
     */
    
    String Username;
    String Password;
    String FirstName;
    String LastName;
    String username;
    String password;
    
    public boolean checkUsername(){
        //This method will check the username complexity if it has an underscore or not
        boolean check = false;
        for(int i = 0; i<Username.length(); i++){
            if(Username.length() <=5){
                
                if((int)Username.charAt(i) ==95)
                    check = true;
            }
        }
        return check;
    }
    
    public boolean checkPasswordComplexity(){
        //This method will check if the password has a capital letter, a number and a special character
        boolean CapitalLetter = false;
        boolean Number = false;
        boolean SpecialCharacter = false;
        for(int i = 0; i<Password.length(); i++){
            if(Password.length() >= 8){
                if((int)Password.charAt(i) >65 &&(int)Password.charAt(i)<65)
                    CapitalLetter = true;
            }
            if((int)Password.charAt(i) >=48 &&(int)Password.charAt(i) <=48)
                Number = true;
        }
        if((int)Password.charAt(0) >=33 &&(int)Password.charAt(0)<=33)
            SpecialCharacter = true;
        
        return CapitalLetter && Number && SpecialCharacter;
    }
    public String registerUser(){
        
        if(checkUsername()==true){
            System.out.println("Username captured successfully");
        }else{
            System.out.println("Username is incorrectly formatted");
        }
        if(checkPasswordComplexity()==true){
            System.out.println("Password successfully captured");
        }else{
            System.out.println("Password is not correct");  
    }
        if(checkUsername()==true && (checkPasswordComplexity()==true)){
            System.out.println("The above requirements have been met");
            
        }
        if(checkPasswordComplexity()==false){
            System.out.println("The Password does not meet the requirements");
            
        }
        if(checkUsername()==false){
            System.out.println("The username is incorrectly formatted");
            
        }    
        
        return(" ");
      
}
   public boolean loginUser(){
       boolean Compare = false;
       // This method will compare the register login username and password
        return false;
        
       
   }
   
   String returnLoginStatus(){
       //this method will tell the user if they managed to login or not
       
       if(loginUser()==true){
           
           System.out.println("Login successful");
           {
           System.out.println("welcome"+" "+FirstName +" "+LastName +" "+ Username+" "+Password+ " ");
           }
       }
       
       else{
           
           System.out.println("A failed login");
           System.out.println("Username or Password incorrect, please try again");
       }
       
       return("");
   }
    
    public static void main(String[] args){
           //This will allow the user to be able to respond to the comparision
        Scanner input = new Scanner(System.in);
        
        // this will be used as access methods and variables of the login register
        
        Login method = new Login();
        
      //prompt the user to enter their first name
            System.out.println("Please enter your first name");
            method.FirstName = input.next();
            //prompt the user to enter their last name
            System.out.println("Please enter your last name");
            method.LastName = input.next();
            //prompt the user to create a username
            System.out.println("Create username");
            method.Username = input.next();
            //prompt the user to create a password
            System.out.println("Create password");
            method.Password = input.next();
            //this will inform the user if they are registered or not
            System.out.println(method.registerUser());
            //if the username and password are correct this will allow the user to register
            if(method.checkUsername()==true & (method.checkPasswordComplexity()==true)){
                
            }
                //prompt the user to login with information they registered with
                System.out.println("Please enter your username");
                method.username = input.next();
                //prompt the user to login with the registered password
                System.out.println("Please enter your password");
                method.password = input.next();
                //this will tell the user if they are registered or not
                System.out.println(method.returnLoginStatus());
                
            }
        
        
    } 
    

