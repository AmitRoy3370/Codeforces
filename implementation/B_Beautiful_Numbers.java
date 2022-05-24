
import java.util.Scanner;

public class B_Beautiful_Numbers {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static int a[];

    static void solve() {

        int position[] = new int[n + 1];

        for (int i = 0; i < n; ++i) {

            position[a[i] - 1] = i;

        }

        int l = n, r = 0;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; ++i) {

            l = Math.min(l, position[i]);
            r = Math.max(r, position[i]);

            if (r - l == i) {

                ans.append(1);

            } else {

                ans.append(0);

            }

        }

        System.out.println(ans.toString());

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = new int[n];

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextInt();

            }

            solve();

        }

    }

}
