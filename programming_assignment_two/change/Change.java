import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
      /*
        For the sake of this assignment,
        we simply need to return the number of
        coins dispensed not their actual values.
        
        Restraints: 1 <= m <= 10^3
        Coin values to check are 1, 5, and 10
      */

      int coins = Math.round(m/10);
      m %= 10;
      coins += Math.round(m/5);
      m %= 5;
      coins += Math.round(m/1);

      return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

