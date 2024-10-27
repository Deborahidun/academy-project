package academy_project.budget_planner; 

import org.junit.jupiter.api.Test; // Import JUnit Test annotation
import static org.junit.jupiter.api.Assertions.assertEquals; // Import assertion method

public class BudgetPlannerTest { // Test class for BudgetPlanner

	
	// Test for remainder calculation
    @Test 
    public void testCalculateRemainder() { 
        FinancialSummary summary = new FinancialSummary(5000.0, 2000.0, 1000.0); 
        assertEquals(2000.0, summary.calculateRemainder()); // Assert expected remainder
    }

    @Test //  Test for expense percentage calculation
    public void testCalculateExpensePercentage() { 
        FinancialSummary summary = new FinancialSummary(5000.0, 2000.0, 1000.0); // Create summary instance
        assertEquals(40.0, summary.calculateExpensePercentage(), 0.01); // Assert expected percentage with delta
    }
}
