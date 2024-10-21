package academy_project.budget_planner;

import java.util.Scanner;

public class Income extends FinancialItem {
    // Constructor initializes the amount from the FinancialItem class to zero
    public Income() {
        this.amount = 0.0; // Initialize the amount from FinancialItem
    }

    // Collects income from the user
    public void collectData() {
        Scanner scanner = new Scanner(System.in);

        // Loop until valid income is entered
        while (true) {
            System.out.print("Enter your total income: "); // Prompt user for total income
            String userInput = scanner.nextLine(); // Read user input

            try {
                // Attempt to parse the user input as a double
                amount = Double.parseDouble(userInput); // Attempt to parse the input

                // Validate the income
                if (amount < 0) {
                    // Throw an exception if the input is negative, enforcing positive income requirement
                    throw new IllegalArgumentException("Income cannot be negative.");
                }
                
                // If we reach here, the input is valid
                break; // Exit the loop on valid input

            } catch (NumberFormatException e) {
                // Handle cases where the input cannot be parsed to a double
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                // Display the exception message for negative income
                System.out.println(e.getMessage()); // Handle negative income case
            }
        }
        
        // Confirmation message after all checks
        System.out.println("Total income has been recorded."); // Inform the user that their input has been successfully recorded
    }

    // Getter for total income
    public double getTotalIncome() {
        // Return the total income for further calculations in the budget planner
        return amount; // Return the total income
    }
}

