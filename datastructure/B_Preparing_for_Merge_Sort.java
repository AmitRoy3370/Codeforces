
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_Preparing_for_Merge_Sort {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int n;

    static long a[];

    static void solve() {

        long copy[] = new long[n];

        System.arraycopy(a, 0, copy, 0, n);

        sort(copy, 0, n - 1);

        boolean ok = true;

        for (int i = 0; i < n; i++) {
            if (a[i] != copy[i]) {
                ok = false;
                break;
            }
        }

        if (ok) {

            for (long i : a) {

                out.print(i + " ");
                out.flush();

            }

            out.println();
            out.flush();

            return;

        }

        /*for(long i: copy)
            System.out.print(i+" ");
        
        System.out.println();*/
        int start = 0, end = n - 1;

        while (start < end) {
            long temp = copy[start];
            copy[start] = copy[end];
            copy[end] = temp;
            start++;
            end--;
        }

        /*for(long i: copy)
            System.out.print(i+" ");
        
        System.out.println();*/
        ok = true;

        for (int i = 0; i < n; i++) {
            if (copy[i] != a[i]) {
                ok = false;
                break;
            }
        }

        if (ok) {

            for (long i : a) {
                System.out.println(i);
            }

            return;

        }

        Stack<Long> stack[] = new Stack[n];

        for (int i = 0; i < n; i++) {
            stack[i] = new Stack<>();
        }

        for (int i = 0; i < n; i++) {
            stack[i].add(Long.MIN_VALUE);
        }

        boolean visited[] = new boolean[n];

        stack[0].add(a[0]);
        
        for (int i = 1; i < n; i++) {

            int left = 0, right = n - 1;

            //visited[i]=true;
            while (right != left) {

                int mid = (left + right) / 2;

                if (stack[mid].peek() < a[i] ) {

                    right=mid;

                } else {

                    left = mid + 1;

                }

            }
            
            stack[left].add(a[i]);

            visited[i] = true;

        }

        for (Stack<Long> i : stack) {

            i.stream().filter((j) -> (j != Long.MIN_VALUE)).forEachOrdered((j) -> {
                System.out.print(j + " ");
            });

            if (i.size() > 1) {

                System.out.println();

            }

        }

    }

    public static void main(String[] amit) throws IOException {

        n = in.nextInt();

        a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        solve();

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

5
1 3 2 5 4


 */

 /*

4
4 3 2 1


 */
