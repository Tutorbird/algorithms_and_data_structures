import java.util.*;

public class Knapsack {
    private static int optimalWeight(int W, int[] w) {
        int K[][] = new int[w.length + 1][W + 1];
        
        // Build table K[][] in bottom up manner
        for (int i = 1; i <= w.length; i++) {
          for (int j = 1; j <= W; j++) {
            int value = K[i - 1][j];
            
            if (w[i - 1] <= j) {
                int val = (K[i - 1][j - w[i - 1]]) + w[i - 1];
                if (value < val) {
                  value = val;
                  K[i][j] = value;
                } else {
                    K[i][j] = value;
                }
            } else {
                K[i][j] = value;
            }
          }
        }
        
        return K[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

        Arrays.sort(w);
        System.out.println(optimalWeight(W, w));
    }
}

