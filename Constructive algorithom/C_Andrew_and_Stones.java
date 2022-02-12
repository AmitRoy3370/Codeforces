
import java.util.Scanner;

public class C_Andrew_and_Stones {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long a[];

    static void solve() {

        if (n == 3 && a[1] % 2 == 1) {

            System.out.println(-1);
            return;

        }

        int greater_than_two = 0;

        for (int i = 1; i < n - 1; i++) {

            if (a[i] >= 2) {

                ++greater_than_two;

            }

        }

        long ans = 0;

        for (int i = 1; i < n - 1; i++) {

            if (a[i] % 2 == 0 && a[i] >= 2) {

                ans += a[i] / 2;

            }else if (a[i] % 2 == 1 && greater_than_two >= 1) {

                ans += (a[i] + 1) / 2;

            }

        }

        if (ans == 0) {

            System.out.println("-1");

        } else {

            System.out.println(ans);

        }

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; i++) {

                a[i] = in.nextLong();

            }

            solve();

        }

    }

}
/*

4
5
1 2 2 3 6
3
1 3 1
3
1 2 1
4
3 1 1 2


 */

 /*

1
5
1 2 2 3 6

 */

/*

1
4
2 3 3 2

*/
