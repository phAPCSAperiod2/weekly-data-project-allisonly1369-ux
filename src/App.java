import java.util.Scanner;

/**
 * Weekly Spending Tracker Application
 * 
 * This application tracks daily spending amounts and provides analysis
 * including total spent, daily average, highest and lowest spending days,
 * and insights about spending habits relative to a weekly budget limit.
 * 
 * @author Allison Ly
 * @collaborator CoPilot
 * @date 1/23/2026
 */
public class App {

    /**
     * Main method - Entry point for the Weekly Spending Tracker application.
     * 
     * This method performs the following operations:
     * 1. Prompts the user for their weekly spending limit
     * 2. Collects daily spending data for each day of the week
     * 3. Creates a WeeklyData object to analyze the spending data
     * 4. Displays a summary report with totals, averages, and extremes
     * 5. Provides insights based on spending patterns and budget comparison
     * 
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Display welcome message and program description
        System.out.println("===== Weekly Spending Tracker =====");
        System.out.println("Track how much money you spend each day of the week!");
        System.out.println();

        // Prompt user for their weekly spending limit
        System.out.print("What is your spending limit for the week? $");
        double weeklyLimit = scanner.nextDouble();
        System.out.println();

        // Create array to store spending data for 7 days
        double[] weekData = new double[7];

        // Array containing the names of each day of the week
        String[] days = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        // Collect spending data for each day of the week with input validation
        for (int i = 0; i < 7; i++) {
            double spendingAmount = -1;

            // Keep prompting until user enters a non-negative value
            while (spendingAmount < 0) {
                System.out.print("Enter spending for " + days[i] + ": $");
                spendingAmount = scanner.nextDouble();

                // Validate input - spending cannot be negative
                if (spendingAmount < 0) {
                    System.out.println("Error: Please enter a non-negative amount.");
                }
            }

            // Store the valid spending amount in the array
            weekData[i] = spendingAmount;
        }

        System.out.println();

        // Create WeeklyData object with the collected spending data
        WeeklyData spending = new WeeklyData(weekData);

        // ===== SUMMARY =====
        // Display spending summary with analysis
        System.out.println("===== Weekly Spending Summary =====");
        System.out.println("Total Spent:   $" + spending.getTotal());
        System.out.println("Daily Average: $" + spending.getAverage());
        System.out.println("Highest Day:   $" + spending.getMax());
        System.out.println("Lowest Day:    $" + spending.getMin());
        System.out.println();

        // ===== DAILY BREAKDOWN =====
        // Display daily breakdown of spending
        System.out.println("===== Daily Breakdown =====");
        System.out.println(spending.toString());

        // ===== INSIGHTS =====
        // Provide insights about spending behavior
        System.out.println("===== Insights =====");
        double totalSpent = spending.getTotal();

        // Compare total spending against weekly budget limit
        if (totalSpent <= weeklyLimit) {
            double remaining = weeklyLimit - totalSpent;
            System.out.println(
                "Great job! You stayed within your budget and have $" +
                remaining + " remaining."
            );
        } else {
            double over = totalSpent - weeklyLimit;
            System.out.println(
                "You exceeded your budget by $" + over +
                ". Try to reduce spending next week."
            );
        }

        // Provide feedback on daily average spending habits
        double dailyAverage = spending.getAverage();
        if (dailyAverage > 50) {
            System.out.println("Warning: Your daily spending is quite high.");
        } else if (dailyAverage > 25) {
            System.out.println("You're spending moderately. Keep an eye on it.");
        } else {
            System.out.println("Nice control! Your daily spending is low.");
        }

        // Close the Scanner resource
        scanner.close();
    }
}
