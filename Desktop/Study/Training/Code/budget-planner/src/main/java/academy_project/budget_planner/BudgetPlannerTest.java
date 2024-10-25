package academy_project.budget_planner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetPlannerTest {

    @Test
    public void testCalculateRemainder() {
        FinancialSummary summary = new FinancialSummary(5000.0, 2000.0, 1000.0);
        assertEquals(2000.0, summary.calculateRemainder());
    }

    @Test
    public void testCalculateExpensePercentage() {
        FinancialSummary summary = new FinancialSummary(5000.0, 2000.0, 1000.0);
        assertEquals(40.0, summary.calculateExpensePercentage(), 0.01);
    }
}
