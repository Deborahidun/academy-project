package academy_project.budget_planner;

import java.util.Scanner;

public class Income extends FinancialItem {
    public Income() {
        this.amount = 0.0; // Initialize the amount from FinancialItem
    }

    // This method sets the total income
    public void setTotalIncome(double totalIncome) {
        if (totalIncome < 0) {
            throw new IllegalArgumentException("Income cannot be negative.");
        }
        this.amount = totalIncome; // Set amount from FinancialItem
    }

    // Collects income from the user
    public void collectData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Income. Please enter your total income.");

        amount = getValidIncome(scanner); // Call the new method to validate income

        System.out.println("Total income has been recorded.");
    }

    // New method to get and validate income
    private double getValidIncome(Scanner scanner) {
        double input = 0;
        while (true) {
            try {
                System.out.print("Enter your total income: ");
                input = Double.parseDouble(scanner.nextLine());

                // Check for negative income
                if (input < 0) {
                    throw new IllegalArgumentException("Income cannot be negative.");
                }

                // Return valid income
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Handle negative income case
            }
        }
        return input;
    }

    // Getter for total income
    public double getTotalIncome() {
        return amount; // Return the total income
    }

    // Checks if income has been entered
    public boolean isIncomeEntered() {
        return amount > 0; // Check if income is greater than 0
    }
}
