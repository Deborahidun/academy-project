package academy_project.budget_planner;

import java.util.Scanner;

// Class to handle income data
public class Income extends FinancialItem {
    private Scanner scanner; 

    // Constructor initializes the scanner and sets amount to zero
    public Income(Scanner scanner) {
        this.scanner = scanner;
        this.amount = 0.0; 
    }

    // Collects income from the user and checks if input is accurate
    @Override
    public void collectData() {
        while (true) {
            System.out.print(ConsoleColors.CYAN + "Enter your total income: " + ConsoleColors.RESET + "\n"); // Prompt user for total income

            try {
                String input = scanner.nextLine();

                // Validate that the input is a positive number or decimal using regex
                if (!input.matches("\\d*\\.\\d+|\\d+")) {
                    throw new NumberFormatException(); 
                }
                
                // Parse the input if it passes the regex check
                amount = Double.parseDouble(input); 

                // Check for zero amount
                if (amount == 0) {
                    throw new IllegalArgumentException(ConsoleColors.RED + "Income cannot be zero." + ConsoleColors.RESET + "\n");
                }

                break; // Exit the loop on valid input

            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "Invalid input. Please enter a valid positive number." + ConsoleColors.RESET + "\n");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Handle zero income case
            }
        }
        System.out.println(ConsoleColors.GREEN + "\nTotal income has been recorded." + ConsoleColors.RESET + "\n"); 
    }
}

