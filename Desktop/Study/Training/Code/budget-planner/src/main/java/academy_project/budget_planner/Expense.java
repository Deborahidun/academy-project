package academy_project.budget_planner;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

// Class to handle expense data
public class Expense extends FinancialItem {
    private HashSet<String> expenseCategories; 
    private HashMap<String, Double> expenseAmounts; 
    private double income; 
    private Scanner scanner; 

    // Constructor initializes income, scanner, default categories, and sets amount to zero
    public Expense(double income, Scanner scanner) {
        this.income = income;
        this.scanner = scanner; 
        this.amount = 0.0; 
        this.expenseCategories = new HashSet<>(); 
        this.expenseAmounts = new HashMap<>(); 

        // Initialize default expense categories
        expenseCategories.add("Housing");
        expenseCategories.add("Transportation");
        expenseCategories.add("Food");
        expenseCategories.add("Entertainment");
        expenseCategories.add("Other");
    }

    @Override
    public void collectData() {
        // Display categories
        System.out.println(ConsoleColors.CYAN + "Available expense categories:" + ConsoleColors.RESET + "\n");
        for (String category : expenseCategories) {
            System.out.println("- " + category);
        }

        double expenseAmount;
        
        //Iterate through categories
        for (String category : expenseCategories) {
            while (true) {
                System.out.print(ConsoleColors.CYAN + "\nEnter the amount for " + category + " (or type '0' to skip): " + ConsoleColors.RESET + "\n");
                String input = scanner.nextLine().trim();

                if (input.equals("0")) {
                    System.out.println(ConsoleColors.MAGENTA + "Skipped " + category + "." + ConsoleColors.RESET + "\n");
                    
                    // Skip to the next category
                    break; 
                }
                   // Validate that the input is a positive number or decimal using regex
                   if (!input.matches("\\d*\\.\\d+|\\d+")) {
                    System.out.println(ConsoleColors.RED + "Invalid input. Please enter a valid positive number." + ConsoleColors.RESET + "\n");
                    continue; // Prompt for the same category again
                }


                try {
                    expenseAmount = Double.parseDouble(input); 

                    // Handle negative or zero amounts
                    if (expenseAmount < 0) {
                        System.out.println(ConsoleColors.RED + "Amount must be greater than zero. Please try again." + ConsoleColors.RESET + "\n");
                        continue; 
                    }

                    // Check if the new expense would exceed the income
                    if (this.amount + expenseAmount > income) {
                        System.out.println(ConsoleColors.RED + "Error: Total expenses cannot exceed your income of $" + income + ". Please enter a valid amount for " + category + "." + ConsoleColors.RESET + "\n");
                       
                     // Prompt for the same category again
                        continue; 
                    }

                    // Add valid expense amount to both total and expenseAmounts map
                    this.amount += expenseAmount;
                    
                    // Store amount in map
                    expenseAmounts.put(category, expenseAmount); 
                    System.out.println(ConsoleColors.GREEN + "Added $" + expenseAmount + " for " + category + ConsoleColors.RESET + "\n");
                    // Exit the inner loop after successful addition
                    break; 

                } catch (NumberFormatException e) {
                    System.out.println(ConsoleColors.RED + "Invalid input. Please enter a valid number." + ConsoleColors.RESET + "\n"); 
                }
            }
        }
    }
}
