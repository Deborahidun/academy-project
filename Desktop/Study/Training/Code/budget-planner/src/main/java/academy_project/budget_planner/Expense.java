package academy_project.budget_planner;

import java.util.ArrayList;
import java.util.Scanner;

// Class to handle expense data
public class Expense extends FinancialItem {
    private ArrayList<String> expenseCategories; // List to store expense categories
    private double income; // Total income available to cover expenses
    private Scanner scanner; // Scanner for user input

    // Constructor initializes income and default categories, and sets amount to zero
    public Expense(double income, Scanner scanner) {
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
        System.out.println("Available expense categories:");
        for (String category : expenseCategories) {
            System.out.println("- " + category);  // Display all categories
        }
        double expenseAmount;

        for (String category : expenseCategories) {
            while (true) {
                System.out.print("\nEnter the amount for " + category + " (or type '0' to skip): ");
                String input = scanner.nextLine().trim();

                if (input.equals("0")) {
                    System.out.println("Skipped " + category + ".\n");
                    break; // Skip to the next category
                }

                try {
                    expenseAmount = Double.parseDouble(input); // Convert input to double

                    if (expenseAmount <= 0) {
                        System.out.println("Amount must be greater than zero. Please try again.\n");
                        continue; // Handle negative or zero amounts
                    }

                    // Check if the new expense would exceed the income
                    if (this.amount + expenseAmount > income) {
                        System.out.println("Error: Total expenses cannot exceed your income of $" + income + ". Please enter a valid amount for " + category + ".\n");
                        continue; // Prompt for the same category again
                    }

                    this.amount += expenseAmount; // Add valid expense amount
                    System.out.println("Added $" + expenseAmount + " for " + category + "\n");
                    break; // Exit the inner loop after successful addition

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.\n"); // Handle non-numeric input
                }
            }
        }
    }
}



