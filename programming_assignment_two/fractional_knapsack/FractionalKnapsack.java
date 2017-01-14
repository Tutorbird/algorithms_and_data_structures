import java.util.Scanner;
import java.text.DecimalFormat;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here

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
