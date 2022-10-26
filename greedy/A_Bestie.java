
import java.util.Scanner;

public class A_Bestie {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long a[];

    static char s[];

    static void solveA() {

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

    static void solveB() {

        int bin[] = new int[2];

        for (char i : s) {

            bin[i - '0']++;

        }

        // if the data is already sorted
        if (bin[0] == n || bin[1] == n) {

            System.out.println(0);
            return;

        }

        // other wise what we have to do?
        boolean first_time = false;

        int operations = 0;

        for (int i = 0; i < n - 1; ++i) {

            if (s[i] == s[i + 1]) {

                continue;

            }

            if (first_time) {

                if (s[i] == '0' && s[i + 1] == '1') {

                    ++operations;

                    first_time = false;

                }

            } else {

                if (s[i] == '1' && s[i + 1] == '0') {

                    ++operations;

                    first_time = true;

                }

            }

        }

        System.out.println(operations);

    }

    public static void main(String[] priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            s = in.next().toCharArray();

            /*a = new long[n + 1];

            for (int i = 1; i <= n; ++i) {

                a[i] = in.nextLong();

            }

            solveA();*/
            solveB();

        }

    }

    static long gcd(long a, long b) {

        if (b == 0) {

            return a;

        }

        return gcd(b, a % b);

    }

}
