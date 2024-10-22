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

    // Method to display the financial summary on the console
    public void displaySummary() {
        System.out.println("\nFinancial Summary:");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Savings Goal: $" + savingsGoal);
    }

    // Method to save the financial summary to a text file
    public void saveSummaryToFile() {
        String filename = "FinancialSummary.txt"; // Specify the filename for the output
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Financial Summary\n");
            writer.write("Total Income: $" + totalIncome + "\n");
            writer.write("Total Expenses: $" + totalExpenses + "\n");
            writer.write("Savings Goal: $" + savingsGoal + "\n");
            System.out.println("Summary saved to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the summary.");
            e.printStackTrace();
        }
    }
}



