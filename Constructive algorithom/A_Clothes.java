import java.util.Scanner;

public class A_Clothes {

    static Scanner in = new Scanner(System.in);

    static int n, m;

    static long a[];

    static long u[], v[];

    static void solve() {

        boolean dp[][] = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {

            dp[(int) u[i]][(int) v[i]] = true;
            dp[(int) v[i]][(int) u[i]] = true;

        }

        long ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                for (int k = 1; k <= n; k++) {

                    if (i!=j && j!=k && k!=i && dp[i][j] && dp[j][k] && dp[k][i]) {

                        ans = Math.min(ans, a[i] + a[j] + a[k]);

                    }

                }

            }

        }

        System.out.println((ans == Integer.MAX_VALUE ? -1 : ans));

    }

    public static void main(String[] amit) {

        n = in.nextInt();
        m = in.nextInt();

        a = new long[n + 1];

        for (int i = 1; i <= n; i++)
            a[i] = in.nextLong();

        u = new long[m];
        v = new long[m];

        for (int i = 0; i < m; i++) {

            u[i] = in.nextInt();
            v[i] = in.nextInt();

        }

        solve();

    }

}
