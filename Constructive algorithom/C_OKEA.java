
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_OKEA {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int testCases, n, k;

    static void solve() {

        if (k == 1) {

            out.println("YES");
            out.flush();

            for (int i = 1; i <= n; i++) {

                System.out.println(i);

            }

            return;

        }

        if (n % 2 == 1) {

            out.println("NO");
            out.flush();

            return;

        }

        if (n == 1 && k == 1) {

            out.println("YES");
            out.flush();

            out.println(1);
            out.flush();

            return;

        }

        if (n % 2 == 0) {

            StringBuilder ans = new StringBuilder();

            out.println("YES");
            out.flush();

            for (int i = 1, j = 1; i <= n * k; i += 2, j++) {

                ans.append(i).append(" ");

                if (k == j) {

                    ans.append("\n");
                    j = 0;

                }

            }

            //ans.append("\n");
            for (int i = 2, j = 1; i <= n * k; i += 2, j++) {

                ans.append(i).append(" ");

                if (k == j) {

                    ans.append("\n");

                    j = 0;

                }

            }

            out.print(ans.toString());
            out.flush();

        }

    }

    public static void main(String[] amit) throws IOException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();
            k = in.nextInt();

            solve();

        }

        in.close();

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
1 1
2 2
3 3
3 1


 */
