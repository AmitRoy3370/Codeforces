
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Good_Subarrays {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static char a[];

    static void solve() {

        long sum = 0;

        Map<Long, Long> map = new HashMap<>();

        long ans = 0;

        map.put((long) ans, (long)1);
		
		int index = 1;

        for (char i : a) {

            sum += i - '0';

            ans += map.containsKey(sum - index) ? map.get(sum - index) : 0;

            map.put((long) (sum - index), map.getOrDefault((long) (sum - index), (long) 0) + (long) 1);
			++index;

        }

        System.out.println(ans);

    }

    public static void main(String[] priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = in.next().toCharArray();

            solve();

        }

    }

}
