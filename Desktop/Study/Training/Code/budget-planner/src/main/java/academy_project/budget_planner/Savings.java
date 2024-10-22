package academy_project.budget_planner;

import java.util.Scanner;

// Class to handle savings data
public class Savings extends FinancialItem {
    private double income; // Reference to the total income
    private Expense expense; // Reference to the Expense class
    private Scanner scanner; // Declare Scanner as a member variable

    // Constructor accepts total income, Expense instance, and Scanner
    public Savings(double income, Expense expense, Scanner scanner) {
        this.income = income;
        this.expense = expense;
        this.scanner = scanner; // Initialize the scanner
        this.amount = 0.0; // Initialize amount from FinancialItem
    }

    // Collects savings data from the user
    @Override
    public void collectData() {
        System.out.print("Enter your savings goal: ");

        while (true) {
            try {
                amount = Double.parseDouble(scanner.nextLine()); // Set the amount

                if (amount < 0) {
                    System.out.println("Please enter a positive amount for savings.");
                } else if (amount + expense.getAmount() > income) {
                    System.out.println("Error: Total savings and expenses cannot exceed your income of $" + income);
                } else {
                    break; // Valid input, exit the loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
            }
        }
    }
}
