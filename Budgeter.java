// Uyen Tran
// 10/27/2020
// CSE 142 AU20
// TA: Rinav Kasthuri
// Assessment 4: Budgeter

// This program will calculate and produce an output of user's 
// total and average income as well as expenses.

import java.util.*;
public class Budgeter {
    public static final int DAYS_IN_MONTH = 31;
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        intro();
        double totalincome = category(console, "income");
        int num1 = form(console);       
        double totalamount = category(console, "expense");
        double totalexpense = expense(console, num1, totalamount);
        average(totalincome, totalexpense);        
        netIncome(totalincome, totalexpense);      
    }

// Print out the introduction of the program
    public static void intro() {
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    }

// Method allows user to type in the number of categories of 
// either income or expense, then calculate the sum of each small category
// returns the added up income/expenses
// Parameters: 
//       Scanner console: the terminal that takes values from user
//       String method: the type of category (income or expense)
    public static double category(Scanner console, String method) {
        System.out.print("How many categories of " + method + "? ");
        int number = console.nextInt();
        double total = 0;
        for (int i = 1; i <= number; i++) {
           System.out.print("    Next " + method +" amount? $"); // Allows user to enter the values
           double amount1 = console.nextDouble();
           total += amount1; // Add up the values
        }
        System.out.println();

        return total;
    }

// Method allows user to enter the form of expenses
// returns the form of expenses
// Paremeters:
//       Scanner console: the terminal that takes values from user
    public static int form(Scanner console) {
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        int usage = console.nextInt();

        return usage;
    }

// Calculate the total expense from the user
// returns the calculated total amount of expenses
// Parameters:
//       Scanner console: the terminal that takes values from user
//       int nums: the form of expenses
//       double total amount: the sum of each expense of user  
    public static double expense(Scanner console, int nums, double totalamount) {       
        double totalexpense = 0;       
        if (nums > 1) {
            totalexpense = totalamount * DAYS_IN_MONTH; // Calculate the total expense when 
                                                        // the form of expenses is daily
        } else {
            totalexpense = totalamount; // Calculate the total expense 
                                        // when the form of expenses is monthly
        }  

        return totalexpense;      
    }

 // Calculate, report the average income and expense per day
 // Parameters:
 //       double totalincome: the total income of user
 //       double totalexpense: the total expense of user   
    public static void average(double totalincome, double totalexpense) {
        double averageincome = totalincome / DAYS_IN_MONTH;
        double averageexpense = totalexpense / DAYS_IN_MONTH;
        System.out.println("Total income = $" + round2(totalincome) + 
                           " ($" + round2(averageincome) + "/day)");
        System.out.println("Total expenses = $" + round2(totalexpense) + 
                           " ($" + round2(averageexpense) + "/day)");
        System.out.println();
    }

// Calculate the net income (overall income) of user and determine the type of spending
// Parameters:
//       double num1: the total income of user
//       double num2: the toal expense of user
    public static void netIncome(double num1, double num2) {
        double change = round2(num1 - num2); // Calculate the change between income and expense
        double finalchange = Math.abs(change); // Take the absolute value of 
                                               // the change between income and expense

        if (change > 0) {
            System.out.println("You earned $" + finalchange + " more than you spent this month.");
            if (change > 250) {
                System.out.println("You're a big saver.");
                System.out.println("Spectacular!");
            } else {
                System.out.println("You're a saver.");
                System.out.println("Keep it up!");
            }
        } else {
            System.out.println("You spent $" + finalchange + " more than you earned this month.");
            if (change > (-250)) {
                System.out.println("You're a spender.");
                System.out.println("Try harder next time.");
            } else {
                System.out.println("You're a big spender.");
                System.out.println("Please keep track on your budget!");
            }
        }
    }

 // Round a real number to 2 decimal places
 // returns the rounded number
 // Parameters:
 //       double num: a real number/value  
    public static double round2(double num) {
        return Math.round(num * 100.0) / 100.0;
    }

}
