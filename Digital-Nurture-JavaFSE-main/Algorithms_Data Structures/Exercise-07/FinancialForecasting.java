public class FinancialForecasting {

    // Recursive algorithm to calculate future value
    // Future Value = Present Value * (1 + Growth Rate) ^ Periods
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base Case: If periods reached 0, no more growth is added
        if (periods == 0) {
            return currentValue;
        }

        // Recursive Case: Calculate the value for the next period
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }
}
