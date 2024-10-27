package academy_project.budget_planner;

import java.util.Scanner;

// Main class for Budget Planner
public class BudgetPlanner {
    private Income income;    
    private Expense expense;  
    private Savings savings;  

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in); 
        int choice; 

        System.out.println(ConsoleColors.MAGENTA + "You are taking your first step to financial freedom." + ConsoleColors.RESET + "\n");

        do {
            System.out.println(ConsoleColors.CYAN + "Please choose an option:" + ConsoleColors.RESET + "\n");
            System.out.println("1. Input Income");
            System.out.println("2. Input Expenses");
            System.out.println("3. Input Savings");
            System.out.println("4. Get Summary");
            System.out.println("5. Exit\n");
            System.out.print(ConsoleColors.CYAN + "Enter the corresponding number for your choice: " + ConsoleColors.RESET + "\n");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1: // Input Income
                        income = new Income(scanner); 
                        income.collectData(); 
                        break;
                    case 2: // Input Expenses
                        if (income == null) {
                            System.out.println(ConsoleColors.RED + "Error: You must enter your income first before adding expenses." + ConsoleColors.RESET + "\n");
                        } else {
                            expense = new Expense(income.getAmount(), scanner); 
                            expense.collectData(); 
                        }
                        break;
                    case 3: // Input Savings
                        if (income == null) {
                            System.out.println(ConsoleColors.RED + "Error: You must enter your income first before adding savings." + ConsoleColors.RESET + "\n");
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

                            FinancialSummary summary = new FinancialSummary(income.getAmount(), totalExpenses, totalSavings); 
                            summary.displaySummary(); 
                            summary.saveSummaryToFile(); 
                        }
                        break;
                    case 5: // Exit
                        System.out.println(ConsoleColors.GREEN + "\nThank you for using the Budget Planner. Goodbye!" + ConsoleColors.RESET + "\n"); 
                        scanner.close(); 
                        return; // Exit the program
                    default: // Invalid choice
                        System.out.println(ConsoleColors.RED + "\nInvalid choice. Please select a valid option." + ConsoleColors.RESET + "\n"); 
                }
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "\nInvalid input. Please enter a valid number." + ConsoleColors.RESET + "\n"); 
                choice = 0; 
            }
        } while (choice != 5); 
    }

    // Main method to run the program
    public static void main(String[] args) {
        BudgetPlanner planner = new BudgetPlanner(); 
        planner.showMainMenu(); 
    }
}



