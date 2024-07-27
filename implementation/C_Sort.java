
import java.util.Scanner;

public class C_Sort {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, q;

    static char a[], b[];

    static void solve() {

        int count[][] = new int[n + 1][26];

        for (int i = 0; i < n; ++i) {

            for (int j = 0; j < 26; ++j) {

                count[i + 1][j] = count[i][j];

            }

            count[i + 1][a[i] - 'a']++;
            count[i + 1][b[i] - 'a']--;

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; ++i) {

            int l = in.nextInt();
            int r = in.nextInt();

            --l;

            int replace = 0;

            for (int j = 0; j < 26; ++j) {

                replace += Math.max(0, count[r][j] - count[l][j]);

            }

            sb.append(replace).append("\n");

        }

        System.out.println(sb.toString().trim());

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
        q = in.nextInt();

        a = in.next().toCharArray();
        b = in.next().toCharArray();

    }

}
