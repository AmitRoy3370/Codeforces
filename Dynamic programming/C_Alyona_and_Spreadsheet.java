
import java.util.Scanner;

public class C_Alyona_and_Spreadsheet {

    static Scanner in = new Scanner(System.in);

    static int n, m, k;

    static long dp[];

    static void solve() {

        dp = new long[n + 1];

        long b[] = new long[m + 1];

        long a[] = new long[m + 1];

        for (int i = 1; i <= n; ++i) {

            dp[i] = i;

            for (int j = 1; j <= m; ++j) {

                long x = in.nextLong();

                if (a[j] > x) {

                    b[j] = i;

                }

                a[j] = x;

                if (dp[i] > b[j]) {

                    dp[i] = b[j];

                }

            }

        }

    }

    public static void main(String[] priya) {

        n = in.nextInt();
        m = in.nextInt();

        solve();

        k = in.nextInt();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < k; ++i) {

            int l = in.nextInt();
            int r = in.nextInt();

            if (dp[r] <= l) {

                ans.append("Yes").append("\n");

            } else {

                ans.append("No").append("\n");

            }

        }

        System.out.print(ans.toString());

    }

}
