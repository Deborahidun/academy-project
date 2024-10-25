package academy_project.budget_planner;

import java.util.Scanner;

// Class to handle savings data
public class Savings extends FinancialItem {
    private Double income; // Reference to the total income
    private Expense expense; // Reference to the Expense class
    private Scanner scanner; // Declare Scanner as a member variable

    // Constructor accepts total income, Expense instance, and Scanner
    public Savings(Double income, Expense expense, Scanner scanner) {
        this.income = income;
        this.expense = expense; 
        this.scanner = scanner; 
        this.amount = 0.0; 
    }

    // Collects savings data from the user
    @Override
    public void collectData() {
        while (true) {
            System.out.print(ConsoleColors.CYAN+ "Enter your savings goal: " + ConsoleColors.RESET + "\n");

            try {
            	// Set the amount
                amount = Double.parseDouble(scanner.nextLine()); 

                // Validate savings goal
                if (amount < 0) {
                    System.out.println(ConsoleColors.RED +"Please enter a positive amount for savings." + ConsoleColors.RESET + "\n");
                } else if (amount > income) {
                    System.out.println(ConsoleColors.RED + "Error: Your savings goal cannot exceed your income of $" + income + ". Please enter a new savings goal." + ConsoleColors.RESET + "\n");
                } else if (expense != null && (amount + expense.getAmount() > income)) {
                    System.out.println(ConsoleColors.RED + "Error: Total savings and expenses cannot exceed your income of $" + income + ". Please enter a new savings goal." + ConsoleColors.RESET + "\n");
                } else {
                    System.out.println(ConsoleColors.GREEN + "Your savings goal of $" + amount + " has been saved." + ConsoleColors.RESET + "\n"); 
                    
                 // Valid input, exit the loop
                    break; 
                }
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "Invalid input. Please enter a valid amount." + ConsoleColors.RESET + "\n");
            }
        }
    }
}



