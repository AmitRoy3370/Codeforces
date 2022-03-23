
import java.util.Scanner;

public class A_Functions_again {

    private static final Scanner in = new Scanner(System.in);

    private static int n;

    private static long a[];

    private static void solve() {

        long suffix[] = new long[n];

        for (int i = n - 1; i >= 1; --i) {

            suffix[i] = Math.abs(a[i] - a[i + 1]);

        }

        long summation = 0, ans = 0, big = 0, small = 0;

        for (int i = n - 1; i >= 0; --i) {

            if (i % 2 == 1) {

                suffix[i] *= -1;

            }

            summation += suffix[i];

            if (i % 2 == 1) {

                ans = Math.max(ans, big - summation);

            } else {

                ans = Math.max(ans, summation - small);

            }

            big = Math.max(big, summation);

            small = Math.min(small, summation);

        }

        System.out.println(ans);

    }

    public static void main(String[] amit) {

        n = in.nextInt();

        a = new long[n + 1];

        for (int i = 1; i <= n; ++i) {

            a[i] = in.nextLong();

        }

        solve();

    }

}
/*

5
1 4 2 3 1


 */

 /*

4
1 5 4 7


 */
