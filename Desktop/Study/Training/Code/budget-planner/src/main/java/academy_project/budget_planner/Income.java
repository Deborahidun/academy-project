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
            System.out.print(ConsoleColors.CYAN + "Enter your total income: " + ConsoleColors.RESET + "\n"); // Prompt user for total income

            try {
                amount = Double.parseDouble(scanner.nextLine()); // Read and parse user input directly
                
                // Check if the income is valid
                if (amount < 0) {
                    throw new IllegalArgumentException(ConsoleColors.RED + "Income cannot be negative." + ConsoleColors.RESET + "\n");
                } else if (amount == 0) {
                    throw new IllegalArgumentException(ConsoleColors.RED + "Income cannot be zero." + ConsoleColors.RESET + "\n"); // Check for zero income
                }
                
                break; // Exit the loop on valid input
                
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "Invalid input. Please enter a valid number." + ConsoleColors.RESET + "\n");
                
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Handle negative or zero income case
            }
        }
        System.out.println(ConsoleColors.GREEN + "\nTotal income has been recorded." + ConsoleColors.RESET + "\n"); 
    }
}



