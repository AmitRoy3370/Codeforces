
import java.util.Scanner;

public class F_Minimize_Fixed_Points {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static int p[];

    static void solve() {

        p = new int[n];

        for (int i = 0; i < n; ++i) {

            p[i] = i + 1;

        }

        for (int i = n / 2; i > 1; --i) {

            for (int j = 2 * i; j <= n; j += i) {

                if (gcd(i * 1L, p[j - 1] * 1L) > 1 && p[i - 1] != j) {

                    int temp = p[i - 1];
                    p[i - 1] = p[j - 1];
                    p[j - 1] = temp;

                }

            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i : p) {

            sb.append(i).append(" ");

        }

        System.out.println(sb.toString().trim());

    }

    public static void main(String[] args) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        n = in.nextInt();

    }

    static long gcd(long a, long b) {

        if (b == 0L) {

            return a;

        }

        return gcd(b, a % b);

    }

}
