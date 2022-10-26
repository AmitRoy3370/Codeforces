
import java.util.Scanner;

public class A_Bestie {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long a[];

    static void solve() {

        long gcd = a[1];

        for (int i = 2; i <= n; ++i) {

            gcd = gcd(a[i], gcd);

        }

        if (gcd == 1L) {

            System.out.println(0);
            return;

        }

        if (gcd(n, gcd) == 1L) {

            System.out.println("1");

        } else if (gcd(n - 1, gcd) == 1L) {

            System.out.println("2");

        } else {

            System.out.println("3");

        }

    }

    public static void main(String[] priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = new long[n + 1];

            for (int i = 1; i <= n; ++i) {

                a[i] = in.nextLong();

            }

            solve();

        }

    }

    static long gcd(long a, long b) {

        if (b == 0) {

            return a;

        }

        return gcd(b, a % b);

    }

}
