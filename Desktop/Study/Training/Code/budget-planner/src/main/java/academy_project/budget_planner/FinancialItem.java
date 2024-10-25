package academy_project.budget_planner;

// Abstract class for financial items (Income, Expense, Savings)
abstract class FinancialItem {
    // Holds the financial value
    protected double amount;

    // Abstract method to collect data
    public abstract void collectData();

    // Returns the amount
    public double getAmount() {
        return amount;
    }
}
