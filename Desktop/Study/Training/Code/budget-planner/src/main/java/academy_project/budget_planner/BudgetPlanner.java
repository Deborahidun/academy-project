package academy_project.budget_planner;

import java.util.Scanner;

// Main class for Budget Planner
public class BudgetPlanner {
    private Income income;    // Instance variable to hold income data
    private Expense expense;  // Instance variable to hold expense data
    private Savings savings;  // Instance variable to hold savings data

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        int choice; // Variable to store user choice

        System.out.println("You are taking your first step to financial freedom.\n");

        do {
            // Display menu options to the user
            System.out.println("Please choose an option:\n");
            System.out.println("1. Input Income");
            System.out.println("2. Input Expenses");
            System.out.println("3. Input Savings (optional)");
            System.out.println("4. Get Summary");
            System.out.println("5. Exit\n");
            System.out.print("Enter the corresponding number for your choice: ");

            // Attempt to read and parse user choice
            try {
                choice = Integer.parseInt(scanner.nextLine());

                // Handle each menu choice
                switch (choice) {
                    case 1: // Input Income
                        income = new Income(scanner); // Create Income instance
                        income.collectData(); // Collect income data
                        break;
                    case 2: // Input Expenses
                        expense = new Expense(income.getAmount(), scanner); // Create Expense instance with income validation inside
                        expense.collectData(); // Collect expense data
                        break;
                    case 3: // Input Savings
                        savings = new Savings(income.getAmount(), expense, scanner); // Create Savings instance
                        savings.collectData(); // Collect savings data
                        break;
                    case 4: // Get Summary
                        FinancialSummary summary = new FinancialSummary(income.getAmount(), expense.getAmount(), savings != null ? savings.getAmount() : 0.0); // Create summary
                        summary.displaySummary(); // Display summary
                        summary.saveSummaryToFile(); // Save summary to file
                        break;
                    case 5: // Exit
                        System.out.println("\nThank you for using the Budget Planner. Goodbye!\n"); // Exit message
                        scanner.close(); // Close scanner
                        return; // Exit the program
                    default: // Invalid choice
                        System.out.println("\nInvalid choice. Please select a valid option.\n"); // Error message for invalid choice
                }
            } catch (NumberFormatException e) { // Handle invalid input
                System.out.println("\nInvalid input. Please enter a valid number.\n"); // Error message for invalid input
                choice = 0; // Set choice to an invalid number to repeat the loop
            }
        } while (choice != 5); // Continue until user chooses to exit
    }

    // Main method to run the program
    public static void main(String[] args) {
        BudgetPlanner planner = new BudgetPlanner(); // Create BudgetPlanner instance
        planner.showMainMenu(); // Show the main menu
    }
}
