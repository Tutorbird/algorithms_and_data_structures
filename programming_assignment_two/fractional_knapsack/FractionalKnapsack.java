import java.util.Scanner;
import java.text.DecimalFormat;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
          
        for (int i = 0; i < values.length; i++) {
          if (capacity == 0)
            return value;

          double temp = 0;
          double quotient = 0;
          int idx = 0;

          for (int j = 0; j < values.length; j++) {
            temp = (double) values[j] / weights[j];
            if (  temp > quotient ) {
              quotient = temp;
              idx = j;
            }
          }

          int min_value = Math.min(weights[idx], capacity);
          value += min_value * quotient;
          capacity -= min_value;
          if (min_value == weights[idx]) {
            values[idx] = 0;
            weights[idx] = 1;
          }
        }

        return value;
      }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat("#.0000");
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(dec.format(getOptimalValue(capacity, values, weights)));
    }
} 
