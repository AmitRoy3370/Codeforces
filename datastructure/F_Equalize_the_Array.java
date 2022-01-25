
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class F_Equalize_the_Array {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long a[];

    static void solve() {

        Map<Long, Long> counting = new HashMap<>();
        Map<Long, Long> reverse_counting = new HashMap<>();
        for (int i = 0; i < n; i++) {
            
            long num = a[i];
            counting.put(num, counting.getOrDefault(num, (long) 0) + 1);
            reverse_counting.put(counting.get(num), reverse_counting.getOrDefault(counting.get(num), (long) 0) + 1);
        
        }
        long max = 0;
        for (long val : reverse_counting.keySet()) {
            long v = val * reverse_counting.get(val);
            max = Math.max(max, v);
        }
        System.out.println(n - max);

    }

//javac F:/Documents/NetBeansProjects/contest/src/F_Equalize_the_Array.java
    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; i++) {

                a[i] = in.nextLong();

            }

            solve();

        }

    }

}
/*

3
6
1 3 2 1 4 2
4
100 100 4 100
8
1 2 3 3 3 2 6 6


 */

 /*

1
6
1 3 2 1 4 2

 */

 /*

1
4
100 100 4 100

 */

 /*

1
8
1 2 3 3 3 2 6 6

 */
