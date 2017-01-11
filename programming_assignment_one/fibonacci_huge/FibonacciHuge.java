import java.util.*;

public class FibonacciHuge {
    private static final int MAX_ARR_LENGTH = 3;
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

        return result[2] % m;
    }

    private static long getPeriodLength(long n, long m) {

        long[] result = new long[MAX_ARR_LENGTH];
        result[0] = result[1] = 1;

        for (long i = 0; i < n; ++i) {
            result[0] = result[1];
            result[1] = result[2];
            result[2] = result[0] + result[1];

            if (result[1] % m == 0 && result[2] % m == 1 && i > 2)
                return i;
        }

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

