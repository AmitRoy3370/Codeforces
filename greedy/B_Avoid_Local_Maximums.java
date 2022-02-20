
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_Avoid_Local_Maximums {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int testCases, n;

    static long a[];

    static StringBuilder finalAns = new StringBuilder();

    static void solve() {

        if (n <= 2) {

            finalAns.append(0).append("\n");

            for (long i : a) {

                finalAns.append(i).append(" ");

            }

            finalAns.append("\n");

            return;

        }

        int occur = 0;

        for (int i = 0; i < n; i++) {

            if (i + 1 < n && i - 1 >= 0 && a[i] > a[i - 1] && a[i] > a[i + 1]) {

                ++occur;

                if (i + 2 <= n - 1) {

                    a[i + 1] = Math.max(a[i], a[i + 2]);

                } else {

                    a[n - 1] = a[n - 2];

                }

            }

        }

        finalAns.append(occur).append("\n");

        for (long i : a) {

            finalAns.append(i).append(" ");

        }

        finalAns.append("\n");

    }

    public static void main(String[] amit) throws IOException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; i++) {

                a[i] = in.nextLong();

            }

            solve();

        }

        out.println(finalAns.toString());
        out.flush();

        in.close();

    }

    static class Scanner {

        BufferedReader in;
        StringTokenizer st;

        public Scanner() {

            in = new BufferedReader(new InputStreamReader(System.in));

        }

        String next() throws IOException {

            while (st == null || !st.hasMoreElements()) {

                st = new StringTokenizer(in.readLine());

            }

            return st.nextToken();

        }

        int nextInt() throws IOException {

            return Integer.parseInt(next());

        }

        long nextLong() throws IOException {

            return Long.parseLong(next());

        }

        String nextLine() throws IOException {

            return in.readLine();

        }

        char nextChar() throws IOException {

            return next().charAt(0);

        }

        double nextDouble() throws IOException {

            return Double.parseDouble(next());

        }

        float nextFloat() throws IOException {

            return Float.parseFloat(next());

        }

        boolean nextBoolean() throws IOException {

            return Boolean.parseBoolean(next());

        }

        void close() throws IOException {

            in.close();

        }

    }

}
/*

5
3
2 1 2
4
1 2 3 1
5
1 2 1 2 1
9
1 2 1 3 2 3 1 2 1
9
2 1 3 1 3 1 3 1 3


 */

 /*

1
9
2 1 3 1 3 1 3 1 3


 */

 /*

1
9
1 2 1 3 2 3 1 2 1

 */

 /*

1
5
1 2 1 2 1

 */

 /*

1
4
1 2 3 1

 */

 /*

1
3
2 1 2

 */
