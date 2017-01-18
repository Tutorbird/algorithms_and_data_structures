import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        /*
         The logic below is based on:
          (n - (i + 1)) > (i + 1)
          Needless reduction to two math ops 
         */
        List<Integer> summands = new ArrayList<Integer>();
        if (n < 3) {
            summands.add(n);
            return summands;
        } else {
            int i = 0;
            do {
                i++;
                summands.add(i);
                n -= i;
            } while (n - i > i + 2);
            summands.add(n);
        }

        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

