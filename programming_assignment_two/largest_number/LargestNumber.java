import java.util.*;

public class LargestNumber {
    private static boolean isGreaterThanOrEqual(String a, String b) {
        if (a.charAt(0) >= b.charAt(0) && a.length() <= b.length()) {
          return true;
        }

        return false;
      }

    private static String largestNumber(String[] a) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j && isGreaterThanOrEqual(a[i], a[j]))  {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

            }
        }

        for(String s : a) {
            builder.append(s);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

