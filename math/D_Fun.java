
import java.util.Scanner;

public class D_Fun {

    static Scanner in = new Scanner(System.in);

    static int testCases;

    static long n, x;

    static void solve() {

        long way = 0L;

        for (long a = 1; a < n; ++a) {

            for (int b = 1; a * b < n; ++b) {

                way += Math.max(0, Math.min(x - a - b, (n - a * b) / (a + b)));

            }

        }

        System.out.println(way);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        n = in.nextLong();
        x = in.nextLong();

    }

}
