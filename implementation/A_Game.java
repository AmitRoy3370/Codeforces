
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Game {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(System.out);

    static StringBuilder ans = new StringBuilder();

    static int testCases, n;

    static int a[];

    static void solve() {

        long final_ans = 0;

        boolean already_ok = true;

        for (int i : a) {

            if (i == 0) {

                already_ok = false;
                break;

            }

        }

        if (already_ok) {

            ans.append(final_ans).append("\n");
            return;

        }

        int start = 0;

        while (start < n && a[start] == 1) {

            ++start;

        }

        --start;

        int end = n - 1;

        while (end >= 0 && a[end] == 1) {

            --end;

        }

        ++end;

        if (end < start) {

            final_ans = 0;

        } else {

            final_ans = end - start;

        }

        ans.append(final_ans).append("\n");

    }

    public static void main(String[] priya) throws IOException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = new int[n];

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextInt();

            }

            solve();

        }

        out.println(ans.toString());
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

        double nextDouble() throws IOException {

            return Double.parseDouble(next());

        }

        void close() throws IOException {

            in.close();

        }

    }

}
/*

1
5
1 0 1 0 1


 */

 /*

3
2
1 1
5
1 0 1 0 1
4
1 0 1 1


 */
