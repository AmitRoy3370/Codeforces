
import java.util.Scanner;

public class E_Air_Conditioners {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, k;

    static int a[];

    static long left[], right[];
    static long dp[], t[];

    static void solve() {

        for (int i = 0; i < n; i++) {

            dp[i] = Integer.MAX_VALUE;
            left[i] = Integer.MAX_VALUE;
            right[i] = Integer.MAX_VALUE;

        }

        for (int i = 0; i < k; i++) {
            dp[a[i] - 1] = t[i];
        }

        long max = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            max = Math.min(max + 1, dp[i]);

            left[i] = max;

        }

        max = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            max = Math.min(max + 1, dp[i]);

            right[i] = max;

        }

        for (int i = 0; i < n; i++) {

            System.out.print(Math.min(left[i], right[i]) + " ");

        }

        System.out.println();

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t1 = 0; t1 < testCases; t1++) {

            n = in.nextInt();

            k = in.nextInt();

            a = new int[k];

            t = new long[k];

            for (int i = 0; i < k; i++) {
                a[i] = in.nextInt();
            }

            for (int i = 0; i < k; i++) {
                t[i] = in.nextLong();
            }

            left = new long[n];
            right = new long[n];
            dp = new long[n];

            solve();

        }

    }

}
/*

5

6 2
2 5
14 16

10 1
7
30

5 5
3 1 4 2 5
3 1 4 2 5

7 1
1
1000000000

6 3
6 1 3
5 5 5


 */

/*

1
6 3
6 1 3
5 5 5

*/

/* 

1
5 5
3 1 4 2 5
3 1 4 2 5

*/
