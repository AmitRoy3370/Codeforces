
import java.util.Scanner;

public class B_Scale {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, k;

    static char mat[][];

    static void solve() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {

            if (i % k != 0) {

                continue;

            }

            for (int j = 0; j < n; ++j) {

                if (j % k != 0) {

                    continue;

                }

                sb.append(mat[i][j]);

            }

            sb.append("\n");

        }

        System.out.print(sb.toString());

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
        k = in.nextInt();

        mat = new char[n][n];

        for (int i = 0; i < n; ++i) {

            mat[i] = in.next().toCharArray();

        }

    }

}
