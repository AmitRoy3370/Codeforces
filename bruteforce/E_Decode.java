
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class E_Decode {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static char x[];

    static long mod = (long) (Math.pow(10, 9) + 7);

    static void solve() {

        Map<Long, Long> count = new HashMap<>();

        long ans = 0L;
        long ones = 0;

        count.put(0L, 1L);

        for (int i = 0; i < n; ++i) {

            if (x[i] == '1') {

                ++ones;

            } else {

                --ones;

            }

            ans = (ans + count.getOrDefault(ones, 0L) * (n - 1 - i + 1)) % mod;
            count.put(ones, (count.getOrDefault(ones, 0L) + i + 2) % mod);

        }

        System.out.println(ans);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        x = in.next().toCharArray();

        n = x.length;

    }

}
