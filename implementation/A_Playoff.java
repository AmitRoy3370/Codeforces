
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Playoff {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(System.out);

    static StringBuilder ans = new StringBuilder();

    static int testCases, n;

    static void solve() {

        long player = power(2, n);

        if (player == 2) {

            ans.append(1).append("\n");
            return;

        }

        ans.append(player - 1).append("\n");

    }

    public static void main(String[] priya) throws IOException {

        testCases = in.nextInt();

        for (int i = 0; i < testCases; ++i) {

            n = in.nextInt();

            solve();

        }

        out.println(ans.toString());
        out.flush();

        in.close();

    }

    static long power(int x, int n) {

        int MAX = 100000;

        if (n == 0) {

            return 1;
        }
        int res[] = new int[MAX];
        int res_size = 0;
        int temp = x;

        while (temp != 0) {
            res[res_size++] = temp % 10;
            temp = temp / 10;
        }

        for (int i = 2; i <= n; i++) {
            res_size = multiply(x, res, res_size);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = res_size - 1; i >= 0; i--) {
            sb.append(res[i]);
        }

        return Long.parseLong(sb.toString());

    }

    static int multiply(int x, int res[], int res_size) {

        int carry = 0;

        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;

            res[i] = prod % 10;

            carry = prod / 10;
        }

        while (carry > 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
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

2
3
1


 */
