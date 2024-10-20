package academy_project.budget_planner;

import java.util.Scanner;

public class Savings extends FinancialItem {
    private double income; // Reference to the total income
    private Expense expense; // Reference to the Expense class

    // Constructor accepts total income and an Expense instance
    public Savings(double income, Expense expense) {
        this.income = income;
        this.expense = expense;
        this.amount = 0.0; // Initialize amount from FinancialItem
    }

    // Collect savings data from the user and validate
    public void collectData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your savings goal: ");

        while (true) {
            try {
                amount = Double.parseDouble(scanner.nextLine()); // Set the amount

                if (amount < 0) {
                    System.out.println("Please enter a positive amount for savings.");
                } else if (amount + expense.getTotalExpenses() > income) {
                    System.out.println("Error: Total savings and expenses cannot exceed your income of $" + income);
                } else {
                    break; // Valid input, exit the loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
            }
        }
    }

    // Getter for savings goal
    public double getSavingsGoal() {
        return amount; // Return the savings goal
    }
}
