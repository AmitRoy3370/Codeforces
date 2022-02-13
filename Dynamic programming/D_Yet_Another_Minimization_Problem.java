
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Yet_Another_Minimization_Problem {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int testCases, n;

    static long a[], b[];

    static void solve() {

        long initial_cost = cost_count(a, b);

        if (initial_cost < 0)
            initial_cost = 0;

        int total_sum = (int) total_sum(a, b);

        boolean dp[][] = new boolean[n + 1][total_sum + 1];

        dp[1][(int) a[0]] = true;
        dp[1][(int) b[0]] = true;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= total_sum; j++) {

                if (j - (int) a[i - 1] >= 0)
                    dp[i][j] |= dp[i - 1][j - (int) a[i - 1]];

                if (j - (int) b[i - 1] >= 0)
                    dp[i][j] |= dp[i - 1][j - (int) b[i - 1]];

            }

        }

        long ans = (n - 2) * a_square_plus_b_square(a, b);

        long a_square_plus_b_square = Long.MAX_VALUE;

        for (int i = 0; i < total_sum; i++) {

            if (!dp[n][i])
                continue;

            long s_sum = i;
            long b_sum = total_sum - s_sum;

            a_square_plus_b_square = Math.min(a_square_plus_b_square, s_sum * s_sum + b_sum * b_sum);

        }

        ans += a_square_plus_b_square;

        out.println(Math.min(ans,initial_cost) );
        out.flush();

    }

    public static void main(String[] amit) throws IOException, ArrayIndexOutOfBoundsException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            a = new long[n];
            b = new long[n];

            for (int i = 0; i < n; i++)
                a[i] = in.nextLong();

            for (int i = 0; i < n; i++)
                b[i] = in.nextLong();

            solve();

        }

        in.close();

    }

    static long cost_count(long a[], long b[]) {

        long square_Sum_of_a_and_b = 0, summation_of_a = 0, summation_of_b = 0;

        for (int i = 0; i < n; i++) {

            square_Sum_of_a_and_b += Math.pow(a[i], 2) + Math.pow(b[i], 2);
            summation_of_a += a[i];
            summation_of_b += b[i];

        }

        long initial_cost = (n - 2) * square_Sum_of_a_and_b + (long) Math.pow(summation_of_a, 2)
                + (long) Math.pow(summation_of_b, 2);

        return initial_cost;

    }

    static long total_sum(long a[], long b[]) {

        long sum = 0;

        for (long i : a)
            sum += i;

        for (long i : b)
            sum += i;

        return sum;

    }

    static long a_square_plus_b_square(long a[], long b[]) {

        long sum = 0;

        for (long i : a)
            sum += i * i;

        for (long i : b)
            sum += i * i;

        return sum;

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
 * 
 * 1
 * 4
 * 3 6 6 6
 * 2 7 4 1
 * 
 */

/*
 * 
 * 1
 * 4
 * 6 7 2 4
 * 2 5 3 5
 * 
 */