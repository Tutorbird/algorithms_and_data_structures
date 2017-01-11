import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {

        if (n <= 1)
          return n;

        /*
          We force the array to only have a size of three since we
          only need the previous two values to calculate the nth
          Fibonacci number. Memory-wise that means we only have
          three long values or, according to the Java documentation,
          20 bytes for an Array                 +
          (4 * 3) for the size of the dimension +
          (4 * 3) for the size of the data type
          _______________________________________
          44 bytes of memory!

          If my calculations are correct, the avg runtime for this algorithm
          is approximately O(n) since we are only dependent on one
          iteration based on the nth number given.
        */
        long period = getPeriodLength(m);
        long previous = 0;
        long current  = 1;
        long count = (n % period);

        return count;
        
    }

    private static long getPeriodLength(long m) {

      long previous_two = 0;
      long previous_one = 1;
      long current = 1;
      long i = 0;

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
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

