package academy_project.budget_planner;

// Abstract class that serves as a blueprint for financial items like Income, Expense, and Savings
abstract class FinancialItem {
    // Protected field 'amount' will hold the financial value for the respective financial item
    protected double amount;

    // Abstract method for collecting data
    public abstract void collectData();

    // Getter for the amount
    public double getAmount() {
        return amount;
    }
}
