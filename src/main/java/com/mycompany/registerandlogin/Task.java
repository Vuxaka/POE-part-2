/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerandlogin;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private String taskName;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskStatus;
    private String taskID;
    private static int taskNumber = 0; // Keeps track of the task number
    
    
    // Constructor
    public Task(String taskName, String developerFirstName, String developerLastName, int taskDuration, String Description, String taskStatus){
        this.taskName = taskName;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        taskNumber++; // Increment taskNumber after each task is created
        this.taskID = createTaskID(); // Generate and assign task ID
        
    }
    
    //Check if task description is less than or equal to 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <=50;
    }
    
    //Generate TaskID: First 2 letters of Task Name + Task Number + Last 3 letters of Developer's Last name
    public String createTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        
    }
    
    
    // Display full task details
    public void printTaskDetails(){
        JOptionPane.showMessageDialog(null,"Task Status: " + taskStatus + "\\nDeveloper:" + developerFirstName + " " +
     developerLastName + "\\nTask Number:" + taskName + "\nTask Name: " + taskName + "\nTask Description: " + taskDescription +
                "\\nTask ID: " + taskID + "\\nTask Duration" + taskDuration + " hours");
               
     
    }
    
  
   //Return the task duration
   public int getDuration(){
       return taskDuration;
       
   }
}



