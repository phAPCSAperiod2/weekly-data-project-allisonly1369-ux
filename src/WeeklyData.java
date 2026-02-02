/**
 * The WeeklyData class stores and analyzes a week’s worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * or any other measurable daily value.
 * 
 * This class provides me
 * 
 * 
 *  thods to calculate statistics including total, average,
 * maximum, and minimum values, as well as a formatted string representation
 * of the daily data.
 * 
 * @author Allison Ly
 * @collaborator CoPilot
 * @date 1/23/2026
 */
public class WeeklyData {

    // Instance variable to store the daily data
    private double[] data;

    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     * 
     * This ensures that external modifications to the input array do not
     * affect the internal data stored in this WeeklyData object.
     *
     * @param input an array representing daily data (can be null or any length)
     */
    public WeeklyData(double[] input) {
        // Handle null input by creating an empty array
        if (input == null) {
            data = new double[0];
        } else {
            // Create new array and copy all values from input
            data = new double[input.length];
            for (int i = 0; i < input.length; i++) {
                data[i] = input[i];
            }
        }
    }

    /**
     * Calculates and returns the total of all values in the week.
     * 
     * Uses a loop to sum all elements in the data array.
     * Returns 0.0 if the array is empty.
     *
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        double total = 0.0;
        // Sum all values in the data array
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        return total;
    }

    /**
     * Calculates and returns the average value for the week.
     * 
     * Divides the total sum by the number of days in the array.
     * Returns 0.0 if the array is empty to avoid division by zero.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        // Prevent division by zero with empty array
        if (data.length == 0) {
            return 0.0;
        }
        // Calculate average as total divided by number of elements
        return getTotal() / data.length;
    }

    /**
     * Finds and returns the highest value in the data array.
     * 
     * Compares all values starting from the first element and keeps track
     * of the maximum value encountered.
     * Returns 0.0 if the array is empty.
     *
     * @return the maximum value in the data array
     */
    public double getMax() {
        // Handle empty array case
        if (data.length == 0) {
            return 0.0;
        }

        // Initialize max with the first element
        double max = data[0];
        // Compare with remaining elements
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    /**
     * Finds and returns the lowest value in the data array.
     * 
     * Compares all values starting from the first element and keeps track
     * of the minimum value encountered.
     * Returns 0.0 if the array is empty.
     *
     * @return the minimum value in the data array
     */
    public double getMin() {
        // Handle empty array case
        if (data.length == 0) {
            return 0.0;
        }

        // Initialize min with the first element
        double min = data[0];
        // Compare with remaining elements
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day’s data.
     * 
     * Each line displays the day number (1-indexed) and its corresponding
     * value formatted with a dollar sign.
     *
     * @return a formatted String representing the week's data
     */
    @Override
    public String toString() {
        String result = "";

        // Build formatted string with each day's data
        for (int i = 0; i < data.length; i++) {
            result += "Day " + (i + 1) + ": $" + data[i] + "\n";
        }

        return result;
    }
}
