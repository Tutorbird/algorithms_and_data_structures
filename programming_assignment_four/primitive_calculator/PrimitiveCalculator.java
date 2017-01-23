import java.util.*;
import java.lang.Math;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        /*
         Initiate the size of the array to the worst-case of adding one
         over and over. 
         We do the safest action of adding first. Then we check whether
         it's divisible by 2 or 3. If it is, we check the last place where
         this growing number was last divisible by that number. We add one
         to that operation list. We check whether the least mutable action
         generated the lowest number of operations or if the last index
         where the number was divisible by the number being checked
        (+ 1 for the current operation) and set it to the new ith value.
         */
        int[] arr = new int[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            }   
        }
    
        for (int i = n; i > 1; ) {
            sequence.add(i);
            if (arr[i - 1] == arr[i] - 1) {
                i -= 1;
            } else if (i % 2 == 0 && (arr[i / 2] == arr[i] - 1)) {
                i /= 2;
            } else if (i % 3 == 0 && (arr[i / 3] == arr[i] - 1)) {
                i /= 3;
            }
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

