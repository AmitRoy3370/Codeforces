
import java.util.Scanner;

public class C_Smilo_and_Minecraft {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, m, k;
    static char grid[][];

    static void solve() {

        long dp[][] = new long[n + 1][m + 1];

        for (int i = 1; i <= n; ++i) {

            for (int j = 1; j <= m; ++j) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + (grid[i - 1][j - 1] == 'g' ? 1 : 0);

            }

        }

        long totalGold = dp[n][m], totalCollected = 0L;

        for (int i = 0; i < n; ++i) {

            for (int j = 0; j < m; ++j) {

                if (grid[i][j] != '.') {

                    continue;

                }

                int i1 = i - k + 1;
                i1 = Math.max(i1, 0);
                
                int i2 = i + k;
                i2 = Math.min(i2, n);
                
                int j1 = j - k + 1;
                j1 = Math.max(j1, 0);
                
                int j2 = j + k;
                j2 = Math.min(j2, m);

                long removedGold = dp[i2][j2] - dp[i2][j1] - dp[i1][j2] + dp[i1][j1];

                long collected = totalGold - removedGold;

                totalCollected = Math.max(totalCollected, collected);

            }

        }

        System.out.println(totalCollected);

    }

    public static void main(String[] Priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();

        grid = new char[n][m];

        for (int i = 0; i < n; ++i) {

            grid[i] = in.next().toCharArray();

        }

    }

}
