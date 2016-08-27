package week1stringproject;

import java.util.Scanner;

/**
 * week1stringproject 
 * created for CSCI 211 
 * last modified 01/18/15
 * @author George Oster
 */
public class Week1StringProject {

    public static void main(String[] args) {

        Scanner qwerty = new Scanner(System.in);
        String email;
        String username;
        String password;
        String exitoragain;
        int loopdecider = 0;
        boolean valid;
        boolean educational;
        
        System.out.println("Hello. We are a new online software subscription service and our service is free");
        System.out.println("to anyone who is a student or who works for a school or college.");
        System.out.println("Users are considered students if they have educational email address.");

        
        // loopdecider is initialized to 0. 
        // the whole program loops until loopdecider increments.
        // loopdecider only increments when the email address is of the form username@domain.edu 

        do {
            
            System.out.print("Please enter your email address and hit enter:  ");
            
            email = qwerty.nextLine();

            valid = isValid(email);//checks if the email address is of the form something@something.something
            
            if (valid == true) {

                educational = isEducationalAddress(email); //checks if the email address ends in .edu

                if (educational == true) {//begin .edu loop   
                    
                    System.out.println("That is a valid educational email address.");
                    username = findUserNameFromEmail(email); //finds the username based on the email address
                   
                    System.out.println("Your username will be " + username + ".");
                    System.out.print("Please enter your desired password and hit enter: ");
                    password = qwerty.nextLine();
                   
                    System.out.println("Well, that is the end of my assignment.");
                    System.out.println("Thank you and good night.");
                   
                    loopdecider++;
                    
                }//end .edu loop

                if (educational == false) {//begin not .edu loop 
                    
                    System.out.println("I'm sorry, but that is not an educational email address.");
                    System.out.println("Would you like to try again?");
                    System.out.println("Hit enter if you would like to try again.");
                    System.out.print("Type N and hit enter to exit the program: ");
                    exitoragain = qwerty.nextLine();
                    
                    if ("N".equals(exitoragain)) 
                        loopdecider++;
                    
                }//end not .edu loop

            }//end valid == true loop

            if (valid == false) 
                System.out.println("I.m sorry, that is not a valid email address. Let's try again.");
            
        } while (loopdecider < 1); // end do-while loop

    }//end main method

    
    
    public static boolean isValid(String address) {
       
        boolean valid = false;
        
        if (address.contains("@")) 
            if (address.indexOf(".") > address.indexOf("@")) 
                if (address.indexOf(".") - address.indexOf("@") > 0) 
                    if (address.indexOf("@") > 0) 
                        if (address.lastIndexOf(".") == address.indexOf(".")) 
                            if (address.lastIndexOf("@") == address.indexOf("@")) 
                                    valid = true;
        return valid;
        
    }//end isValid

    
    
    public static boolean isEducationalAddress(String address) {
        
        boolean indicate = false; 
        
        if (address.endsWith(".edu")) 
            indicate = true;
        
        return indicate;
        
    }//end isEducationalAddress

    
    
    public static String findUserNameFromEmail(String address) {
        
        int atsymbol = address.indexOf("@");
        String username = address.substring(0, atsymbol);
        return username;
        
    }//end findUserNameFromEmail

    
}//end class Week1emailUsername
