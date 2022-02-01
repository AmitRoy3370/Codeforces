import java.util.Scanner;

public class D1_Encrypting_Messages {

    static Scanner in = new Scanner(System.in);

    static int n, m, c;

    static int a[], b[];

    private static void solve() {

        long total = 0;

        long dp[] = new long[n];

        for (int i = 0; i < n; i++) {

            if (i < m)
                total += b[i];

            if (i > n - m) {

                total -= b[i - (n - m + 1)];

            }

            dp[i] = (a[i] + total) % c;

        }

        for (long i : dp)
            System.out.print(i + " ");

    }

    public static void main(String[] amit) {

        n = in.nextInt();
        m = in.nextInt();
        c = in.nextInt();

        a = new int[n];
        b = new int[m];

        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        for (int i = 0; i < m; i++)
            b[i] = in.nextInt();

        solve();

    }

}
