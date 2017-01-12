import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {

        if (n <= 1)
          return n;

        /*
         we get the remainder, or count, by using the formula given
         in the assignment. n = (x * period) + remainder. As such...
         remainder = n % period
        
         We add 2 to n since S(n) = F(n + 2) - 1
         We initialize the m to 10 since that will give up the last digit 
        */

        long m = 10; 
        long period = getPeriodLength(m);
        long count = ( (n + 2) % period);
        long sum = getFibonacciModM(count, m) - 1;

        return sum;
        
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
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

