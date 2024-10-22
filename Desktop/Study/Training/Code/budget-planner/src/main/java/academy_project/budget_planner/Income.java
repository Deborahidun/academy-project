package academy_project.budget_planner;

import java.util.Scanner;

// Class to handle income data
public class Income extends FinancialItem {
    private Scanner scanner; // Declare Scanner as a member variable

    // Constructor initializes the scanner and sets amount to zero
    public Income(Scanner scanner) {
        this.scanner = scanner;
        this.amount = 0.0; 
    }

    // Collects income from the user
    @Override
    public void collectData() {
        while (true) {
            System.out.print("Enter your total income: "); // Prompt user for total income

            try {
                amount = Double.parseDouble(scanner.nextLine()); // Read and parse user input directly
                if (amount < 0) {
                    throw new IllegalArgumentException("Income cannot be negative.");
                }
                break; // Exit the loop on valid input
                
            } catch (NumberFormatException e) {
            	
                System.out.println("Invalid input. Please enter a valid number.");
                
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Handle negative income case
            }
        }
        System.out.println("\nTotal income has been recorded.\n"); 
    }
}


