import java.util.Scanner;

public class Fibonacci {
  private static final int MAX_ARR_LENGTH = 3;
  private static long calc_fib(int n) {

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

    for (int i = 0; i < n; ++i) {
      result[0] = result[1];
      result[1] = result[2];
      result[2] = result[0] + result[1];
    }

    return result[2];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
