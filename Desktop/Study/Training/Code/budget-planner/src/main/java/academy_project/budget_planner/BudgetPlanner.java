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

        System.out.println(ConsoleColors.MAGENTA + "You are taking your first step to financial freedom." + ConsoleColors.RESET + "\n");

        do {
            // Display menu options to the user
            System.out.println(ConsoleColors.CYAN + "Please choose an option:" + ConsoleColors.RESET + "\n");
            System.out.println("1. Input Income");
            System.out.println("2. Input Expenses");
            System.out.println("3. Input Savings (optional)");
            System.out.println("4. Get Summary");
            System.out.println("5. Exit\n");
            System.out.print(ConsoleColors.CYAN +"Enter the corresponding number for your choice: " + ConsoleColors.RESET + "\n");

            // Read and parse user choice
            try {
                choice = Integer.parseInt(scanner.nextLine());

                // Handle each menu choice
                switch (choice) {
                    case 1: // Input Income
                        income = new Income(scanner); // Create Income instance
                        income.collectData(); 
                        break;
                    case 2: // Input Expenses
                        if (income == null) {
                            System.out.println(ConsoleColors.RED + "Error: You must enter your income first before adding expenses." + ConsoleColors.RESET + "\n");
                        } else {
                            expense = new Expense(income.getAmount(), scanner); // Create Expense instance with income validation inside
                            expense.collectData(); 
                        }
                        break;
                    case 3: // Input Savings
                
                        if (income == null) {
                            System.out.println(ConsoleColors.RED +"Error: You must enter your income first before adding savings." + ConsoleColors.RESET + "\n");
                        } else {
                            savings = new Savings(income.getAmount(), expense, scanner); 
                            savings.collectData(); 
                        }
                        break;

                        
                    case 4: // Get Summary
                        if (income == null || (expense == null && savings == null)) {
                            System.out.println(ConsoleColors.RED + "Error: You must enter both income and at least one of expenses or savings before getting a summary." + ConsoleColors.RESET + "\n");
                        } else {
                            double totalSavings = (savings != null) ? savings.getAmount() : 0.0;
                            double totalExpenses = (expense != null) ? expense.getAmount() : 0.0;

                            FinancialSummary summary = new FinancialSummary(income.getAmount(), totalExpenses, totalSavings); // Create summary
                            summary.displaySummary(); 
                            summary.saveSummaryToFile(); 
                        }
                        break;
                    case 5: // Exit
                        System.out.println(ConsoleColors.GREEN + "\nThank you for using the Budget Planner. Goodbye!" + ConsoleColors.RESET + "\n"); 
                        scanner.close(); // Close scanner
                        return; // Exit the program
                    default: // Invalid choice
                        System.out.println(ConsoleColors.RED + "\nInvalid choice. Please select a valid option." + ConsoleColors.RESET + "\n"); // Error message for invalid choice
                }
            } catch (NumberFormatException e) { // Handle invalid input
                System.out.println(ConsoleColors.RED + "\nInvalid input. Please enter a valid number." + ConsoleColors.RESET + "\n"); // Error message for invalid input
                choice = 0; // Set choice to an invalid number to repeat the loop
            }
        } while (choice != 5); // Continue until user chooses to exit
    }

    // Main method to run the program
    public static void main(String[] args) {
        BudgetPlanner planner = new BudgetPlanner(); 
        planner.showMainMenu(); 
    }
}


