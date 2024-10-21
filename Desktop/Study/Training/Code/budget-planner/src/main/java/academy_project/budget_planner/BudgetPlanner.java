package academy_project.budget_planner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BudgetPlanner {
    private Income income;    // Instance variable to hold income data
    private Expense expense;  // Instance variable to hold expense data
    private Savings savings;  // Instance variable to hold savings data

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        int choice; // Variable to store user choice

        System.out.println("You are taking your first step to financial freedom.\n");

        while (true) {
            // Display menu options to the user
            System.out.println("Please choose an option by entering the corresponding number:");
            System.out.println("1. Input Income");
            System.out.println("2. Input Expenses");
            System.out.println("3. Input Savings (optional)");
            System.out.println("4. Get Summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            try {
                choice = scanner.nextInt(); // Read user input
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1: // Option 1: Input Income
                        income = new Income(); // Initialize the Income object
                        income.collectData(); // Call collectData directly to gather income information
                        break;

                    case 2: // Option 2: Input Expenses
                        if (income == null) {
                            System.out.println("\nPlease enter your income first.\n");
                        } else {
                            expense = new Expense(income.getTotalIncome()); // Initialize Expense object
                            expense.collectData(); // Collect expense data from the user
                        }
                        break;

                    case 3: // Option 3: Input Savings (optional)
                        if (income == null || expense == null) {
                            System.out.println("\nPlease enter both income and expenses first.\n");
                        } else {
                            savings = new Savings(income.getTotalIncome(), expense); // Initialize Savings object
                            savings.collectData(); // Collect savings goal from the user
                        }
                        break;

                    case 4: // Option 4: Get Summary
                        if (income == null || expense == null) {
                            System.out.println("\nPlease enter both income and expenses first.\n");
                        } else {
                            double totalSavings = (savings != null) ? savings.getSavingsGoal() : 0.0; // Get savings goal if it exists
                            FinancialSummary summary = new FinancialSummary(income.getTotalIncome(), expense.getTotalExpense(), totalSavings);
                            
                            summary.displaySummary(); // Display the financial summary on the console
                            summary.saveSummaryToFile(); // Save the financial summary to a file
                        }
                        break;

                    case 5: // Option 5: Exit the program
                        System.out.println("\nExiting. Thank you for using the Budget Planner!\n");
                        return; // Exit the loop and terminate the program

                    default: // Handle invalid input
                        System.out.println("\nInvalid option. Please enter a number between 1 and 5.\n");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input types
                System.out.println("\nInvalid input. Please enter a valid number.\n");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    public static void main(String[] args) {
        BudgetPlanner planner = new BudgetPlanner(); // Create a BudgetPlanner instance
        planner.showMainMenu(); // Show the main menu for user interaction
    }
}


