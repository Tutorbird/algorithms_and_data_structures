import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {

        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;
        long min = 0;

        for (long i = 0; i < to + 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            if (i == from - 1)
                min = current - 1;
        }

        System.out.println("Min: " + min + ", Current: " + (current - 1));

        return (current - min - 1) % 10;

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

