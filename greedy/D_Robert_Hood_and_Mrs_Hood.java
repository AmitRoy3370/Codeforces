
import java.util.Scanner;

public class D_Robert_Hood_and_Mrs_Hood {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, d, k;

    static int l[], r[];

    static void solve() {

        long prefix[] = new long[n + 2];

        for (int i = 0; i < k; ++i) {

            prefix[Math.max(1, l[i] - d + 1)]++;
            prefix[r[i] + 1]--;

        }

        int minIndex = 1, maxIndex = 1;

        //StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n - d + 1; ++i) {

            prefix[i] += prefix[i - 1];

            if (prefix[i] < prefix[minIndex]) {

                minIndex = i;

            }

            if (prefix[i] > prefix[maxIndex]) {

                maxIndex = i;

            }

            //sb.append(maxIndex).append(" ").append(minIndex).append("\n");
        }

        System.out.println(maxIndex + " " + minIndex);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        n = in.nextInt();
        d = in.nextInt();
        k = in.nextInt();

        l = new int[k];
        r = new int[k];

        for (int i = 0; i < k; ++i) {

            l[i] = in.nextInt();
            r[i] = in.nextInt();

        }

    }

}
