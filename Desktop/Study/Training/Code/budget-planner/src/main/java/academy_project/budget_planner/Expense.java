package academy_project.budget_planner;

import java.util.ArrayList;
import java.util.Scanner;

public class Expense extends FinancialItem {

    private ArrayList<String> expenseCategories; // A list to store different categories of expenses
    private double income; // The total income available to cover expenses
    private Scanner scanner; // Declare Scanner as a member variable

    // Constructor initializes income and default categories, and sets amount to zero
    public Expense(double income) {
        this.income = income; // Store the income provided when creating an Expense object
        this.amount = 0.0; // Initialize total expenses (inherited from FinancialItem)

        // Initialize default expense categories
        expenseCategories = new ArrayList<>(); // Create a list to hold expense categories
        expenseCategories.add("Housing");
        expenseCategories.add("Transportation");
        expenseCategories.add("Food");
        expenseCategories.add("Utilities");
        expenseCategories.add("Entertainment");
        expenseCategories.add("Other");

        // Initialize the Scanner
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void collectData() {
        System.out.println("Please fill at least one expense category.\n"); // Prompt for user input

        while (true) { // Start a loop that continues until the user decides to stop
            // Display categories with corresponding numbers
            for (int i = 0; i < expenseCategories.size(); i++) {
                System.out.println((i + 1) + ". " + expenseCategories.get(i)); // Show each category with a number
            }

            // Ask the user to enter a category number or type 'done' to finish
            System.out.print("\nEnter the category number (or type 'done' to finish): ");
            String input = scanner.nextLine(); // Read user input

            // If the user types 'done', exit the loop and stop asking for input
            if (input.equalsIgnoreCase("done")) {
                break; // Exit if user is done
            }
            
            try {
                // Convert the user input into a number and adjust it for the list index
                int categoryNumber = Integer.parseInt(input) - 1; // Adjust index for zero-based array
                // Check if the number entered is valid (within the range of categories)
                if (categoryNumber < 0 || categoryNumber >= expenseCategories.size()) {
                    System.out.println("Invalid category number. Please try again.\n");
                    continue; // If invalid, ask again
                }

                // Get the selected category using the validated number
                String category = expenseCategories.get(categoryNumber); // Get the selected category
                // Call a method to get the expense amount for the selected category
                double expenseAmount = getExpenseAmount(category); // Get expense amount

                // Check if the total expenses would exceed the user's income
                if (this.amount + expenseAmount > income) {
                    System.out.println("Error: Total expenses cannot exceed your income of $" + income + "\n");
                } else {
                    this.amount += expenseAmount; // Add the valid expense amount to the total
                    System.out.println("Added $" + expenseAmount + " for " + category + "\n"); // Confirm the addition
                }

            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid number
                System.out.println("Invalid input. Please enter a valid number.\n");
            }
        }
    }

    // Method to prompt and retrieve a valid expense amount
    private double getExpenseAmount(String category) {
        double expense; // Variable to hold the expense amount
        while (true) { // Keep asking for input until a valid amount is received
            System.out.print("Enter the amount for " + category + ": "); // Prompt for the amount
            try {
                // Read the user's input and try to convert it into a number
                expense = Double.parseDouble(scanner.nextLine());
                if (expense < 0) {
                    // If the amount is negative, ask the user to enter a positive amount
                    System.out.println("Please enter a positive amount.\n");
                } else {
                    return expense; // If valid, return the expense amount
                }
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid number
                System.out.println("Invalid input. Please enter a valid amount.\n");
            }
        }
    }

    @Override
    public double getAmount() {
        return this.amount; // Return the total amount spent on expenses
    }

    // Getter for total expenses
    public double getTotalExpense() {
        return this.amount; // Return the total expenses for further calculations in the budget planner
    }
}



