
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_Array_Walk {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int testCases, n, forward, backward;

    static int path[];

    static void solve() {

        long ans = Long.MIN_VALUE;

        for (int time = 0; time <= backward; ++time) {

            long sum = 0;

            int have_to_go = forward - 2 * time;

            if (have_to_go < 0) {

                continue;

            }

            long max = 0;

            for (int i = 0; i <= have_to_go; ++i) {

                if (i < n - 1) {

                    max = Math.max(max, path[i] + path[i + 1]);

                }

                sum += path[i];

            }

            ans = Math.max(ans, sum + time * max);

        }

        out.println(ans);
        out.flush();

    }

    public static void main(String[] priya) throws IOException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();
            forward = in.nextInt();
            backward = in.nextInt();

            path = new int[n];

            for (int i = 0; i < n; i++) {

                path[i] = in.nextInt();

            }

            solve();

        }

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

4
5 4 0
1 5 4 3 2
5 4 1
1 5 4 3 2
5 4 4
10 20 30 40 50
10 7 3
4 6 8 2 9 9 7 4 10 9


 */


 /*

1
5 4 1
1 5 4 3 2

 */

/*

1
10 7 3
4 6 8 2 9 9 7 4 10 9

*/
