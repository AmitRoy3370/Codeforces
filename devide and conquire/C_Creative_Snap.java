
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_Creative_Snap extends Thread {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int n, k, A, B;

    static int a[];

    static long total_have = Long.MAX_VALUE;

    static long detect_cost(int start, int end) {

        long length = end - start + 1, have_avengers = 0;

        int left = 0, right = k - 1;

        while (right >= left) {
            // System.out.println("blocked here");
            int middle = (left + right) / 2;

            // System.out.println("middle: "+middle);
            if (a[middle] >= start) {

                right = middle - 1;

            } else {

                left = middle + 1;

            }

        }

        have_avengers = left;

        left = 0;
        right = k - 1;

        while (right >= left) {
            // System.out.println("blocked here");
            int middle = (left + right) / 2;

            // System.out.println("middle: "+middle);
            if (a[middle] <= end) {

                left = middle + 1;

            } else {

                right = middle - 1;

            }

        }

        have_avengers = right - have_avengers + 1;

        total_have = have_avengers;

        if (have_avengers == 0) {

            // System.out.println("cost: " + A + " length: " + length + " range: " + start +
            // " " + end + " avengers: " + have_avengers);
            // System.out.println("here");
            return A;

        }

        // System.out.println("cost: " + B * length * have_avengers + " length: " +
        // length + " range: " + start + " " + end + " avengers: " + have_avengers);
        return B * have_avengers * length;

    }

    static long solve(int start, int end) {

        long cost = detect_cost(start, end);

        if (start >= end) {

            // System.out.println("enter here " + cost);
            return cost;

        }

        int mid = (start + end) / 2;

        if (total_have <= 0) {

            total_have = Long.MAX_VALUE;

            return cost;

        }

        // long total_cost = detect_cost(start, end);

        // cost=total_cost;

        // System.out.println("cost here: "+cost);
        return Math.min(solve(start, mid) + solve(mid + 1, end),
                cost);

    }

    @Override
    public void run() {
        // super.run(); //To change body of generated methods, choose Tools | Templates.

        try {

            n = in.nextInt();
            k = in.nextInt();
            A = in.nextInt();
            B = in.nextInt();

            a = new int[k];

            for (int i = 0; i < k; i++) {
                a[i] = in.nextInt();
            }

            sort(a, 0, k - 1);

            long ans = solve(1, (int) Math.pow(2, n));

            out.println(Math.min(ans, detect_cost(1, (int) Math.pow(2, n))));
            out.flush();

        } catch (IOException e) {

        }

    }

    public static void main(String[] amit) {

        new Thread(null, new C_Creative_Snap(), "Main", 1 << 28).start();

    }

    static void merge(int a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                a[k] = L[i];

                i++;

            } else {

                a[k] = R[j];

                j++;

            }

            k++;

        }

        while (i < n1) {

            a[k] = L[i];

            i++;
            k++;

        }

        while (j < n2) {

            a[k] = R[j];

            j++;
            k++;

        }

    }

    static void sort(int a[], int left, int right) {

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

2 2 1 2
1 3


 */

 /* 

3 2 1 2
1 7


 */

 /* 

3 2 7 1
7 8

 */
