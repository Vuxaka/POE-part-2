/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registerandlogin;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class RegisterAndLogin {

    public static void main(String[] args) {
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

