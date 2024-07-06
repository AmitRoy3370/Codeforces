import java.util.Scanner;

public class A_Pride {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long [] a;

    static void solve() {

        long gcd = 0L;

        int ones = 0;

        for(long i : a) {

            gcd = gcd(gcd, i);

            if(i == 1) {

                ++ones;

            }

        }

        if(ones != 0) {

            System.out.println(n - ones);
            return;

        }

        if(gcd != 1) {

            System.out.println("-1");
            return;

        }

        int minOperationsToGetOne = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            gcd = a[i];

            for(int j = i + 1; j < n; j++) {

                gcd = gcd(gcd, a[j]);

                if(gcd == 1) {

                    minOperationsToGetOne = Math.min(minOperationsToGetOne, j - i);
                    break;

                }

            }

        }

        gcd = minOperationsToGetOne + n - 1;

        System.out.println(gcd);

    }

    public static void main(String[] priya) {

        testCases = 1;

        for(int t = 0; t < testCases; t++) {

            input();
            solve();

        }

    }

    private static void input() {

        n = in.nextInt();

        a = new long[n];

        for(int i = 0; i < n; i++) {

            a[i] = in.nextLong();
        }

    }

    private static long gcd(long a, long b) {

        if(b == 0) {

            return a;

        }

        return gcd(b, a % b);

    }

}
