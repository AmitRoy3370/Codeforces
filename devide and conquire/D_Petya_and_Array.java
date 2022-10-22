
import java.util.Scanner;

public class D_Petya_and_Array {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long a[], prefix[];

    static long compared_sum, way = 0L;

    // this is deviding part take O(log(n))
    static long solve(long[] prefix, int left, int right) {

        if (left < right) {

            int mid = (left + right) >> 1;

            long left_segment = solve(prefix, left, mid);

            long right_segment = solve(prefix, mid + 1, right);

            long analysis = solve(prefix, left, mid, right);

            return left_segment + right_segment + analysis;

        } else if (left == right) {

            return prefix[left] < compared_sum ? 1L : 0L;

        } else {

            return 0L;

        }

    }

    // this is conquire part will take O(n)
    static long solve(long[] prefix, int left, int mid, int right) {

        int n1 = mid - left + 1;

        int n2 = right - mid;

        long L[] = new long[n1 + 1];

        long R[] = new long[n2 + 1];

        for (int i = 0; i < n1; ++i) {

            L[i] = prefix[left + i];

        }

        for (int j = 0; j < n2; ++j) {

            R[j] = prefix[mid + j + 1];

        }

        L[n1] = Long.MAX_VALUE;
        R[n2] = Long.MAX_VALUE;

        int i = 0, j = 0;

        int prefix_index_i = 0, prefix_index_j = 0;
        long segment_sum = 0;

        for (int k = left; k <= right; ++k) {

            if (L[i] <= R[j]) {

                prefix[k] = L[i++];

            } else {

                prefix[k] = R[j++];

            }

        }

        while (prefix_index_i < n1 && prefix_index_j < n2) {

            if (R[prefix_index_j] - L[prefix_index_i] < compared_sum) {

                segment_sum = segment_sum + (n1 - prefix_index_i);
                ++prefix_index_j;

            } else {

                ++prefix_index_i;

            }

        }

        return segment_sum;

    }

    static void solve() {

        prefix = new long[n];

        prefix[0] = a[0];

        for (int i = 1; i < n; ++i) {

            prefix[i] = prefix[i - 1] + a[i];

        }

        way = solve(prefix, 0, n - 1); // complexity O(n * log(n))

        System.out.println(way);

    }

    public static void main(String[] priya) {

        n = in.nextInt();

        compared_sum = in.nextLong();

        a = new long[n];

        for (int i = 0; i < n; ++i) {

            a[i] = in.nextLong();

        }

        solve();

    }

    static void print(long a[]) {

        for (long i : a) {

            System.out.print(i + " ");

        }

        System.out.println();

    }

}
/*

5 4
5 -1 3 4 -1


 */

 /*

3 0
-1 2 -3


 */

 /*

4 -1
-2 1 -2 3


 */
