package academy_project.budget_planner;

import java.util.Scanner;

// Class to handle savings data
public class Savings extends FinancialItem {
    private Double income; 
    private Expense expense; 
    private Scanner scanner; 

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
            System.out.print(ConsoleColors.CYAN + "Enter your savings goal: " + ConsoleColors.RESET + "\n");

            String input = scanner.nextLine().trim(); // Read input once

               // Validate that the input is a positive number or decimal using regex
            if (!input.matches("\\d*\\.\\d+|\\d+")) {
                System.out.println(ConsoleColors.RED + "Invalid input. Please enter a valid positive amount." + ConsoleColors.RESET + "\n");
                continue; // Prompt for input again
            }

            try {
                // Set the amount
                amount = Double.parseDouble(input);

                // Validate savings goal
                if (amount < 0) {
                    System.out.println(ConsoleColors.RED + "Please enter a positive amount for savings." + ConsoleColors.RESET + "\n");
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


