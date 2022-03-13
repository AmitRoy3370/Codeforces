
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_Fault_tolerant_Network {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(System.out);

    static int testCases, n;

    static long a[], b[];

    static StringBuilder finalAns = new StringBuilder();

    static int max_difference(long arr[], long comparator) {

        int pos = -1;

        int len = arr.length;

        long min = Long.MAX_VALUE;

        for (int i = 0; i < len; ++i) {

            if (min > Math.abs(arr[i] - comparator)) {

                min = Math.abs(arr[i] - comparator);
                pos = i;

            }

        }

        return pos;

    }

    static void solve() {

        int a1[] = {0, max_difference(b, a[0]), n - 1};
        int a2[] = {0, max_difference(b, a[n - 1]), n - 1};

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < a1.length; ++i) {

            for (int j = 0; j < a2.length; ++j) {

                long ans1 = Math.abs(a[0] - b[a1[i]]) + Math.abs(a[n - 1] - b[a2[j]]);

                if (a1[i] > 0 && a2[j] > 0) {

                    ans1 += Math.abs(b[0] - a[max_difference(a, b[0])]);

                }

                if (a1[i] < n - 1 && a2[j] < n - 1) {

                    ans1 += Math.abs(b[n - 1] - a[max_difference(a, b[n - 1])]);

                }

                ans = Math.min(ans, ans1);

            }

        }

        finalAns.append(ans).append("\n");

    }

    public static void main(String[] priya) throws IOException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = new long[n];
            b = new long[n];

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextLong();

            }

            for (int i = 0; i < n; ++i) {

                b[i] = in.nextLong();

            }

            solve();

        }

        out.println(finalAns.toString());
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
1 10 1
20 4 25
4
1 1 1 1
1000000000 1000000000 1000000000 1000000000


 */
