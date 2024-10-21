package academy_project.budget_planner;

// Abstract class that serves as a blueprint for financial items like Income, Expense, and Savings
abstract class FinancialItem {
    
    // Protected field 'amount' will hold the financial value for the respective financial item
    protected double amount;

    
    // This method is be responsible for collecting data related to income, expenses, or savings
    public abstract void collectData();

    // Method to return the amount for a financial item
    public double getAmount() {
        return amount;
    }
}
