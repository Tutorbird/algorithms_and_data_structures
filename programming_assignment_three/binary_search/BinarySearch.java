import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        /*
         If we get one or the initial midpoint is correct,
         return that index. Else we decide to look left
         or right.
         */

        int m = (a.length) / 2;
        int index = -1;

        if (a.length == 1) {
            if (a[0] == x) {
                return 0;
            } else {
                return -1;
            }
        } else if (a[m] == x) {
            for (int i = m; i > -1; i--) {
                if (a[i] != x) {
                    return i + 1;
                } else if (i == 0) {
                    return 0;
                }
            }
        } else if (a[m] > x) {
            index += binarySearch(Arrays.copyOfRange(a, 0, m), x) + 1;
        } else if (a[m] < x) {
            if (x <= a[a.length - 1] && (m + 1) < a.length) {
                int temp = binarySearch(Arrays.copyOfRange(a, (m + 1), a.length), x);
                if (temp == index) {
                    return -1;
                }
                return index + m + 2;
            } else {
                return -1;
            }
        }

        return index;
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
            System.out.println(binarySearch(a, b[i]));
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
