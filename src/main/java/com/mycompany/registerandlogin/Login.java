/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerandlogin;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
    
    String Username;
    String Password;
    String FirstName;
    String LastName;
    String username;
    String password;
    
    
    public boolean checkUsername(){
        //Check if the username contains underscore and is not too short
        return Username.contains("_") && Username.length() > 5;
    }
    
    
    public boolean checkPasswordComplexity() {
        // Check for at least one capital letter, number, and special character
        boolean hasCapital = false, hasNumber = false, hasSpecial = false;
        
        if (Password.length() >= 8) {
            for (char c : Password.toCharArray()) {
                if (Character.isUpperCase(c)) hasCapital = true;
                if (Character.isDigit(c)) hasNumber = true;
                if (Character.isLetterOrDigit(c)) hasSpecial = true;
            }
        }
        
        return hasCapital && hasNumber && hasSpecial;
            }
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        // Check if entered credentials match registered credentials
        return username.equals(Username) && password.equals(Password);
   
        }
    
    public String returnLoginStatus() {
        if (loginUser(username, password)) {
            System.out.println("Login successful");
            return "Welcome " + FirstName + " " + LastName + "!";
        }else{
            System.out.println("A failed login");
            return "Username or Password incorrect, please try again.";
        }
    }
    
     public String registerUser(){
         if (checkUsername() && checkPasswordComplexity()) {
             return "Registration successful!";
         }else {
             String errorMsg = "";
             if (!checkUsername()) errorMsg += "Username is incorrectly formatted.\n";
             if (!checkPasswordComplexity()) errorMsg += "Password does not meet complexity requirements.\n";
             return errorMsg + "Registration failed.";
         }
     }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login method = new Login();
        
        
        //Registration process
        System.out.println("Please enter your first name:");
        method.FirstName = input.nextLine();
        System.out.println("Please enter your last name:");
        method.LastName = input.nextLine();
        System.out.println("Create username:");
        method.username = input.nextLine();
        System.out.println("Create password:");
        method.password = input.nextLine();
        
        // Register user
        String registrationResult = method.registerUser();
        System.out.println(registrationResult);
        if (!registrationResult.equals("Registration successful!")) {
            input.close();
            return; //Exit if registration fails
        }
            
        
        // Login process 
        System.out.println("Please enetr your username to log in:");
        String enteredUsername = input.nextLine();
        System.out.println("Please enter your password");
        String enteredPassword = input.nextLine();
        
        if (method.loginUser(enteredUsername, enteredPassword)) {
            System.out.println("Login successful! Welcome to EasyKanban");
            showMainMenu(input);
            
        } else {
            System.out.println("Login failed. Incorrect username or password.");
            
        } 
        
        input.close();
    }
        
    // Main menu method        
    public static void showMainMenu(Scanner input) {
        List<Task> tasks = new ArrayList<>();
        int totalHours = 0;
        boolean quit = false;
        
        
        while (!quit) {
            System.out.println("\nChoose an option:\n1) Add tasks\n2 Show report\n3) Quit ");
            int option = input.nextInt();
            input.nextLine(); // Consume newline
        
   
                switch (option) {
                    case 1:
                        System.out.println("How many tasks would you like to add?");
                        int numTasks = input.nextInt();
                        input.nextLine(); // Consume newline
                        
                        for (int i = 0; i < numTasks; i++){
                            //Get task details from user
                            System.out.println("Enter task name:");
                            String taskName = input.nextLine();
                            System.out.println("Enter deveeloper's first name");
                            String devFirstName = input.nextLine();
                            System.out.println("Enter developer's last name");
                            String devLastName = input.nextLine();
                            System.out.println("Enter task duration in hours");
                            int taskDuration = input.nextInt();
                            input.nextLine(); // Consume newline
                            System.out.println("Enter task description");
                            String taskDescription = input.nextLine();
                            System.out.println("Enter task status [To Do, Doing, Done]:");
                            String taskStatus = input.nextLine();
                            
                            
                            // Create new Task object
                            Task task = new Task(taskName, devFirstName, devLastName, taskDuration, taskDescription, taskStatus);
                            task.printTaskDetails();
                            
                            if (task.checkTaskDescription()) {
                                tasks.add((task));
                                totalHours += task.getDuration();
                            } else {
                                System.out.println("Task descriptioninvalid. Task not added.");
                            }
                        }    
                            break;
                            
                            
                    case 2: 
                        System.out.println("Coming Soon");
                        break;
                        
                        
                    case 3:
                        quit = true;
                        break;
                        
                        
                    default:
                        System.out.println("Invalid option. Please try again");
                
                            }
                                   
        }    
                            
        System.out.println("Total task duration:" + totalHours + " hours");
                            
                            
                            
                            
                            
                            
                            }
                            
                        }
                      
     

