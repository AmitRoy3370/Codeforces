
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class E_Binary_Deque {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] priya) {

        int testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            int n = in.nextInt();
            int x = in.nextInt();

            int a[] = new int[n];

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextInt();

            }

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int len = -1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
                if (map.containsKey(sum - x)) {
                    len = Math.max(len, i - map.get(sum - x));
                }
                map.putIfAbsent(sum, i);

            }
            if (len == -1) {

                System.out.println("-1");

            } else {
                System.out.println(n - len);

            }

        }

    }

}
