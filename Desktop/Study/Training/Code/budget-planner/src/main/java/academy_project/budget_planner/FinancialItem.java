package academy_project.budget_planner;

abstract class FinancialItem {
    protected double amount;

    public abstract void collectData();

    public double getAmount() {
        return amount;
    }
}
