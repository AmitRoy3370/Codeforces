
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class E_Rendez_vous_de_Marian_et_Robin {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, m, h;

    static int a[], u[], v[], w[];

    static void solve(List<ArrayList<ArrayList<Integer>>> list, long weight[], int source, int n) {

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(arr -> arr[1]));

        pq.add(new long[]{source, 0});

        weight[source] = 0L;

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            int node = (int) current[0];
            long currentWeight = current[1];

            if (currentWeight > weight[node]) {

                continue;

            }

            for (ArrayList<Integer> neighbour : list.get(node)) {

                int nextNode = neighbour.get(0);
                int edgeWeight = neighbour.get(1);

                if (weight[nextNode] > currentWeight + edgeWeight) {

                    weight[nextNode] = currentWeight + edgeWeight;
                    pq.add(new long[]{nextNode, weight[nextNode]});

                }

            }

        }

    }

    static void solve() {

        Set<Integer> set = new HashSet<>();

        for (int i : a) {

            set.add(i);

        }

        List<ArrayList<ArrayList<Integer>>> list = new ArrayList<>();

        for (int i = 0; i < 2 * n + 1; ++i) {

            list.add(new ArrayList<>());

        }

        for (int i = 0; i < m; ++i) {

            list.get(u[i]).add(new ArrayList<>(Arrays.asList(v[i], w[i])));
            list.get(v[i]).add(new ArrayList<>(Arrays.asList(u[i], w[i])));

            list.get(u[i] + n).add(new ArrayList<>(Arrays.asList((v[i] + n), w[i] / 2)));
            list.get(v[i] + n).add(new ArrayList<>(Arrays.asList(u[i] + n, w[i] / 2)));

        }

        for (int i = 1; i <= n; ++i) {

            if (set.contains(i)) {

                list.get(i).add(new ArrayList<>(Arrays.asList(i + n, 0)));

            }

        }

        long weight1[] = new long[2 * n + 1];
        long weight2[] = new long[2 * n + 1];

        Arrays.fill(weight1, Long.MAX_VALUE);
        Arrays.fill(weight2, Long.MAX_VALUE);

        long ans = Long.MAX_VALUE;

        solve(list, weight1, 1, n);
        solve(list, weight2, n, n);

        for (int i = 1; i <= n; ++i) {

            long minForm1 = Math.min(weight1[i], weight1[i + n]);
            long minFormn = Math.min(weight2[i], weight2[i + n]);

            ans = Math.min(ans, Math.max(minForm1, minFormn));

        }

        if (ans != Long.MAX_VALUE) {

            System.out.println(ans);

        } else {

            System.out.println("-1");

        }

    }

    public static void main(String[] args) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        n = in.nextInt();
        m = in.nextInt();
        h = in.nextInt();

        a = new int[h];

        u = new int[m];
        v = new int[m];
        w = new int[m];

        for (int i = 0; i < h; ++i) {

            a[i] = in.nextInt();

        }

        for (int i = 0; i < m; ++i) {

            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();

        }

    }

}
