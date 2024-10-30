/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registerandlogin;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author RC_Student_lab
 */
public class RegisterAndLogin {
    
    
    public static void main(String[] args) {
        //Create an instance of the Login class
        Login login = new Login();
        Scanner input = new Scanner(System.in);
        
        
        
        //1. Registration Phase
        System.out.println("Welcome to the Registration System");
        System.out.println("Please enter your first name:");
        login.FirstName = input.nextLine();
        
        
        System.out.println("Please enter your last name:");
        login.LastName = input.nextLine();
        
        
        System.out.println("Create your username (must contain an underscore and be longer than 5 characters):");
        login.Password = input.nextLine();
        
        
        System.out.println("Create your password (nust be at least 8 charcters long icluding a capital letter and numbers");
        
        
        //Register the user
        String registrationResult = login.registerUser();
        if (registrationResult.equals("Registration successful ")) {
            System.out.println("Registration complete! You can log in.");
        } else {
            System.out.println(registrationResult);
            return; // If registration fails, exit the program
        }
        
        
        //2. Login Phase
        System.out.println("Please log in access your account");
        System.out.println("Enter the username:");
        login.username = input.nextLine();
        
        
        System.out.println("Enter your password:");
        login.password = input.nextLine();
        
        
        if (login.loginUser(registrationResult, registrationResult)) {
            System.out.println("Login successful! Welcome to EasyKanban.");
            showMainMenu(input, login);
        } else {
            System.out.println("Login failed. Please check your username or password.");
            
        }
        
        
        input.close();
        
    }
    
    
    // Main menu method
    public static void showMainMenu(Scanner input, Login login) {
        boolean isRunning = true;
        
        while (isRunning) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Tasks");
            System.out.println("2. Show Report (Coming Soon)");
            System.out.println("3. Quit");
            System.out.println("Please select an option: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline
            
            
            switch (choice) {
                case 1:
                    taskManagement(input);
                    break;
                case 2:
                    System.out.println("Coming Soon!");
                    break;
                case 3:
                    System.out.println("Thank you for using EasyKanban. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    
    // Task management method
    public static void taskManagement(Scanner input) {
        List<Task> tasks = new ArrayList<>();
        
        
        System.out.println("How many tasks would like to enter?");
        int numTasks = input.nextInt();
        input.nextLine(); // Consume the newline
        
        
        for (int i = 0; i < numTasks; i++) {
           System.out.println("\nEntering details for Task" + (i+1));
           
           
           System.out.println("Enter task name: ");
           String taskName = input.nextLine();
           
           
           System.out.println("Enter developer's first name: ");
           String devFirstName = input.nextLine();
           
           System.out.println("Enter developer's last name: ");
           String devLastName = input.nextLine();
           
           
           System.out.println("Enter task duaration in hours: ");
           int taskDuration = input.nextInt();
           input.nextLine(); // Consume newline
           
           
           System.out.println("Enter task description: ");
           String taskDescription = input.nextLine();
           
           System.out.println("Enter task status [To Do, Doing, Done]: ");
           String taskStatus = input.nextLine();
           
           //Create a new task object with the provided details 
           Task task = new Task(taskName, devFirstName, devLastName, taskDuration, taskDescription, taskStatus);
           task.printTaskDetails(); //Print task information
           
           if (task.checkTaskDescription()) {
               tasks.add(task); // Only add the tasks if its valid     
            } else{
               System.out.println("Task not captured due to an invalid description.");
           }
        }
        
        
        //Display total duration of all tasks entered
        int totalHours = tasks.stream().mapToInt(Task::getDuration).sum();
        System.out.println("Total hours across all tasks: " + totalHours + " hours");
        
        
        // Option to display tasks
        System.out.println("Would you like to view all task details? (yes/no) ");
        String viewDetails = input.nextLine();
        if (viewDetails.equalsIgnoreCase("yes")) {
            for (Task task : tasks) {
                task.printTaskDetails();
            }
        }
    }
    }

    