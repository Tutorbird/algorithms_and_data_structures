import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        /*
         If we get one or the initial midpoint is correct,
         return that index. Else we decide to look left
         or right.
         */

        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x < a[mid]) {
                high = mid - 1;
            } else if (x > a[mid]) {
                low = mid + 1;
            } else if (x == a[mid]) {
                for (int i = mid; i > -1; i--) {
                    if (x != a[i]) {
                        return i + 1;
                    }
                    mid = i;
                }
                return mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] data = {1,1,2,2,2,2,5,6};

        // for (int i = -1; i < 8; i++) {
        //     System.out.println(binarySearch(data, i));
        // }
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
