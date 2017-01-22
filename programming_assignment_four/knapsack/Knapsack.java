import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int max_result = 0;
        
        for (int i = w.length - 1; i >= 0; i--) {
          int result = 0;  
          for (int j = i; j >= 0; j--) {
            if (result + w[j] <= W) {
              result += w[j];
            }
          }
          
          if (i == w.length - 1) {
            max_result = result;
          } else if (result > max_result) {
            max_result = result;
          }
          
        }
        return max_result;
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

