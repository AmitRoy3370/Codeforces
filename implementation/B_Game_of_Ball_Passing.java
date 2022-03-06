
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_Game_of_Ball_Passing {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(System.out);

    static StringBuilder final_ans = new StringBuilder();

    static int testCases, n;

    static long a[];

    static long detect_sum(long sum, int i) {

        if (i == n - 1) {

            return sum;

        }

        return detect_sum(sum + a[i], i + 1);

    }

    static void solve() {

        sort(a, 0, n - 1);

        if (a[n - 1] == 0) {

            final_ans.append(0).append("\n");

            return;

        }

        long sum = detect_sum(0, 0);

        long ans = a[n - 1] - sum;

        final_ans.append(Math.max(ans, 1)).append("\n");

    }

    public static void main(String[] priya) throws IOException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextLong();

            }

            solve();

        }

        out.println(final_ans.toString());
        out.flush();

    }

    static void merge(long a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        long L[] = new long[n1];

        long R[] = new long[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                a[k1] = L[i];

                i++;

            } else {

                a[k1] = R[j];

                j++;

            }

            k1++;

        }

        while (i < n1) {

            a[k1] = L[i];

            i++;

            k1++;

        }

        while (j < n2) {

            a[k1] = R[j];

            j++;
            k1++;

        }

    }

    static void sort(long a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

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

4
4
2 3 3 2
3
1 5 2
2
0 0
4
1000000000 1000000000 1000000000 1000000000


 */

/*

1
4
2 3 3 2

*/
