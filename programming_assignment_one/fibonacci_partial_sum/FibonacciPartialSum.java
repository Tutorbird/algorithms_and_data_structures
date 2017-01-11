import java.util.*;

public class FibonacciPartialSum {
    private static int MAX_ARR_LENGTH = 3;
    private static long getFibonacciPartialSumNaive(long from, long to) {
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
        long[] result = new long[MAX_ARR_LENGTH];
        result[0] = result[1] = 1;

        for (int i = 0; i < n + 2; ++i) {
            result[0] = result[1];
            result[1] = result[2];
            result[2] = result[0] + result[1];
        }

        return result[2] - 1;
        // if (to <= 1)
        //     return to;

        // long previous = 0;
        // long current  = 1;

        // for (long i = 0; i < from - 1; ++i) {
        //     long tmp_previous = previous;
        //     previous = current;
        //     current = tmp_previous + current;
        // }

        // long sum = current;

        // for (long i = 0; i < to - from; ++i) {
        //     long tmp_previous = previous;
        //     previous = current;
        //     current = tmp_previous + current;
        //     sum += current;
        // }

        // return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

