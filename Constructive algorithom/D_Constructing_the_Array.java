
import java.util.PriorityQueue;
import java.util.Scanner;

public class D_Constructing_the_Array {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    private static void solve() {

        PriorityQueue<pair> pq = new PriorityQueue<>((pair o1, pair o2) -> {
            if (o1.size == o2.size) {
                return o1.left - o2.left;
            } else {
                return o2.size - o1.size;
            }
        });

        pq.add(new pair(1, n));

        int ans[] = new int[n + 1];

        int mid = 1 + (n - 1) / 2, k = 1;

        for (int i = 1; i <= n; ++i) {

            pair p = pq.poll();

            mid = p.left + ((p.right - p.left) / 2);

            ans[mid] = k++;

            pq.add(new pair(p.left, mid - 1));

            pq.add(new pair(mid + 1, p.right));

        }

        for (int i = 1; i <= n; ++i) {

            System.out.print(ans[i] + " ");

        }

        System.out.println();

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            solve();

        }

    }

    private static class pair {

        int left, right, size;

        public pair(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = this.right - this.left + 1;
        }

    }
}
/*

6
1
2
3
4
5
6


 */

 /*

1
5

 */

 /*

1
6

 */
