
import java.util.Scanner;

public class C_Fibonacci {

    static Scanner in = new Scanner(System.in);

    static long n, mod = 1000000007L;

    static void solve() {

        long unit[][] = new long[2][2];

        for (int i = 0; i < 2; ++i) {

            unit[i][i] = 1L;

        }

        long mat[][] = new long[][]{{0L, 1L}, {1L, 1L}};

        while (n > 0) {

            if (n % 2L == 1L) {

                unit = mul(unit, mat);

            }

            mat = mul(mat, mat);

            n /= 2L;

        }

        System.out.print(unit[1][0]);

    }

    public static void main(String[] priya) {

        n = in.nextLong();

        solve();

    }

    static long[][] mul(long a[][], long b[][]) {

        int len = a.length;

        long ans[][] = new long[len][len];

        for (int i = 0; i < len; ++i) {

            for (int j = 0; j < len; ++j) {

                for (int k = 0; k < len; ++k) {

                    ans[i][k] += a[i][j] * b[j][k];

                    ans[i][k] %= mod;

                }

            }

        }

        return ans;

    }

}
