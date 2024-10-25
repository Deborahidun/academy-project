package academy_project.budget_planner;

import java.util.ArrayList;
import java.util.Scanner;

// Class to handle expense data
public class Expense extends FinancialItem {
    private ArrayList<String> expenseCategories; // List to store expense categories
    private Double income; // Total income available to cover expenses (use Double for null checks)
    private Scanner scanner; // Scanner for user input

    // Constructor initializes income and default categories, and sets amount to zero
    public Expense(Double income, Scanner scanner) {
        this.income = income; // Store the income provided
        this.scanner = scanner; // Initialize the scanner
        this.amount = 0.0; // Initialize total expenses
        this.expenseCategories = new ArrayList<>(); // Create a list to hold expense categories

        // Initialize default expense categories
        expenseCategories.add("Housing");
        expenseCategories.add("Transportation");
        expenseCategories.add("Food");
        expenseCategories.add("Entertainment");
        expenseCategories.add("Other");
    }

    @Override
    public void collectData() {
         
    	//Displays categories
        System.out.println(ConsoleColors.CYAN + "Available expense categories:" + ConsoleColors.RESET + "\n");
        for (String category : expenseCategories) {
            System.out.println("- " + category);  
        }
        //stores converted input
        double expenseAmount;

        
        for (String category : expenseCategories) {
            while (true) {
                System.out.print(ConsoleColors.CYAN + "\nEnter the amount for " + category + " (or type '0' to skip): " + ConsoleColors.RESET + "\n");
                String input = scanner.nextLine().trim();

                if (input.equals("0")) {
                    System.out.println(ConsoleColors.MAGENTA + "Skipped " + category + "." + ConsoleColors.RESET + "\n");
                    break; // Skip to the next category
                }

                try {
                    expenseAmount = Double.parseDouble(input); // Convert input to double

                    // Handle negative or zero amounts
                    if (expenseAmount < 0) {
                        System.out.println(ConsoleColors.RED + "Amount must be greater than zero. Please try again." + ConsoleColors.RESET + "\n");
                        continue; 
                    }

                    // Check if the new expense would exceed the income
                    if (this.amount + expenseAmount > income) {
                        System.out.println(ConsoleColors.RED + "Error: Total expenses cannot exceed your income of $" + income + ". Please enter a valid amount for " + category + "." + ConsoleColors.RESET + "\n");
                        continue; // Prompt for the same category again
                    }

                    // Add valid expense amount
                    this.amount += expenseAmount; 
                    System.out.println(ConsoleColors.GREEN + "Added $" + expenseAmount + " for " + category + ConsoleColors.RESET + "\n");
                    break; // Exit the inner loop after successful addition

                    // Handle non-numeric input
                } catch (NumberFormatException e) {
                    System.out.println(ConsoleColors.RED + "Invalid input. Please enter a valid number." + ConsoleColors.RESET + "\n"); 
                }
            }
        }
    }
}
