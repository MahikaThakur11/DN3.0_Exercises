import java.util.Scanner;

public class FinancialForecasting {
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
    
        if (periods == 0) {
            return currentValue;
        }

        double nextValue = currentValue * (1 + growthRate);
        return calculateFutureValue(nextValue, growthRate, periods - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = scanner.nextDouble();
        System.out.print("Enter annual growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();
        System.out.print("Enter number of periods: ");
        int periods = scanner.nextInt();

        double futureValue = calculateFutureValue(currentValue, growthRate, periods);
        System.out.printf("The future value after %d periods is: %.2f\n", periods, futureValue);

        scanner.close();
    }
}
