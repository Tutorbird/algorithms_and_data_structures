import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        double recurring = Math.sqrt(5);
        double first_half = ((1 + recurring) / 2);
        double second_half = ((1 - recurring) / 2);
        double result = (1/recurring) * ( Math.pow(first_half, (n + 2)) - Math.pow(second_half, (n + 2)) );

        return result - 1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

