
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Min_Or_Sum {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int testCases, n;

    static long a[];

    static StringBuilder finalAns = new StringBuilder();

    static void solve() {

        long ans = 0;

        for (long i : a) {

            ans |= i;

        }

        finalAns.append(ans).append("\n");

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

    static class citation implements Comparable<citation> {

        long element;

        public citation(long element) {
            this.element = element;
        }

        @Override
        public int compareTo(citation t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            return Long.compare(this.element, t.element);

        }

    }

}
/*

4
3
1 3 2
5
1 2 4 8 16
2
6 6
3
3 5 6


 */

/*

1
5
1 2 4 8 16

*/
