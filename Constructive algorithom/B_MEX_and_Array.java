
import java.util.Scanner;

public class B_MEX_and_Array {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long a[];

    static void solve() {

        long ans = 0;

        for (int len = 1; len <= n; len++) {

            for (int i = 0, j = len - 1; j < n; j++, i++) {

                long number_of_zeros = 0;

                for (int k = i; k <= j; k++) {

                    if (a[k] == 0) {

                        ++number_of_zeros;

                    }

                }

                ans += number_of_zeros;
                ans += len;

            }

            // System.out.println("len: "+len+" ans: "+ans);
        }

        System.out.println(ans);

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
2
1 2
3
2 0 1
4
2 0 5 1
5
0 1 1 0 1


 */

 /*

1
3
2 0 1

 */

/*

1
4
2 0 5 1

*/
