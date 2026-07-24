public class MainEx7 {
    public static void main(String[] args) {
        double currentValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate per period
        int periods = 10; // Number of periods (e.g., years)

        double futureValue = FinancialForecasting.calculateFutureValue(currentValue, growthRate, periods);

        System.out.printf("Current Value: $%.2f\n", currentValue);
        System.out.printf("Growth Rate: %.2f%%\n", growthRate * 100);
        System.out.println("Periods: " + periods);
        System.out.printf("Predicted Future Value: $%.2f\n", futureValue);
    }
}
