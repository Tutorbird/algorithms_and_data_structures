import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long n) {

        if (n <= 1)
          return n;

        /*
         we get the remainder, or count, by using the formula given
         in the assignment. n = (x * period) + remainder. As such...
         remainder = n % period
        
         We add 2 to n since S(n) = F(n + 2) - 1
         We initialize the m to 1000 in order to do subtraction from 
         the upper bound to the lower bound. Likewise, we return a mod 10
         value in order to get only the last digit.
        */

        long m = 10000; 
        long period = getPeriodLength(m);
        long upper = ( (n + 2) % period);
        long lower = ( (from + 1) % period);
        long sum_lower = getFibonacciModM(lower, m) - 1;
        long sum_upper = getFibonacciModM(upper, m) - 1;
        long sum = sum_upper - sum_lower;
        
        if (sum == -1)
            sum = 9;

        return sum % 10;
        
    }

    private static long getFibonacciModM(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous % m) + (current % m);
        }

        return current % m;
    }

    private static long getPeriodLength(long m) {

      long previous_two = 0;
      long previous_one = 1;
      long current = 1;
      long i = 0;
      /*
        This is based on the principal given in the assignment that each
        recurrence starts with a 0 and 1
      */
      do {
          current = (previous_one + previous_two) % m;
          previous_two = previous_one;
          previous_one = current;
          ++i;
      } while ( !(previous_two == 0 && previous_one == 1) );
    
      return i;

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

