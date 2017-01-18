import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[segments.length + 1];

        int count = 1;
        points[0] = segments[0].end;

        for (int i = 1; i < segments.length; i++) {
            if ((segments[i].start > points[count - 1] || points[count - 1] > segments[i].end)) {
                points[count] = segments[i].end;
                count++;
            }

        }
        points[points.length - 1] = count;

        return points;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Segment other) {

            int other_end = ((Segment) other).end;

            //ascending order
            return this.end - other_end;

        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        Arrays.sort(segments);
        int[] points = optimalPoints(segments);
        int result = points[points.length - 1];
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(points[i] + " ");
        }
    }
}
 
