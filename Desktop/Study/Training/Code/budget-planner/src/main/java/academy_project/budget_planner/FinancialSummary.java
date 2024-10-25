package academy_project.budget_planner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Class to display and save the financial summary
public class FinancialSummary {
    private double totalIncome;
    private double totalExpenses;
    private double savingsGoal;

    // Constructor to initialize financial summary values
    public FinancialSummary(double totalIncome, double totalExpenses, double savingsGoal) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.savingsGoal = savingsGoal;
    }

    // Method to calculate the remainder
    public double calculateRemainder() {
        return totalIncome - totalExpenses - savingsGoal;
    }

    // New Method: Calculate percentage of income spent on expenses
    public double calculateExpensePercentage() {
        if (totalIncome == 0) {
            return 0; // Avoid division by zero if totalIncome is somehow zero
        }
        return (totalExpenses / totalIncome) * 100;
    }

    // Method to display the financial summary on the console
    public void displaySummary() {
        System.out.println(ConsoleColors.CYAN + "Financial Summary:" + ConsoleColors.RESET + "\n");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Savings Goal: $" + savingsGoal);
        System.out.println(ConsoleColors.GREEN + "Remainder: $" + calculateRemainder() + ConsoleColors.RESET + "\n"); 
    }

    // Method to save the financial summary to a text file
    public void saveSummaryToFile() {
        String filename = "FinancialSummary.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Financial Summary\n");
            writer.write("Total Income: $" + totalIncome + "\n");
            writer.write("Total Expenses: $" + totalExpenses + "\n");
            writer.write("Savings Goal: $" + savingsGoal + "\n");
            writer.write("Remainder: $" + calculateRemainder() + "\n"); 
            writer.write("Percentage of Income Spent on Expenses: " + calculateExpensePercentage() + "%\n");
            System.out.println(ConsoleColors.CYAN + "Summary saved to " + filename + ConsoleColors.RESET + "\n");
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED + "An error occurred while saving the summary." + ConsoleColors.RESET + "\n");
            e.printStackTrace();
        }
    }
}



