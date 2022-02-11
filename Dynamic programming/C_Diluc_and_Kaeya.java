import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Diluc_and_Kaeya {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static char a[];

    static void solve() {

        Map<String, Integer> map = new HashMap<>();

        StringBuilder ans = new StringBuilder();

        int countD = 0, countK = 0;

        for (int i = 0; i < n; i++) {

            if (a[i] == 'D')
                countD++;
            else
                countK++;

            long tempCountD = countD, tempCountK = countK;

            if (tempCountD == 0) {

                tempCountK = 1;

            } else if (tempCountK == 0) {

                tempCountD = 1;

            } else {

                long gcd = gcd(tempCountD, tempCountK);

                tempCountD /= gcd;
                tempCountK /= gcd;

            }

            String key = tempCountD + " : " + tempCountK;

            map.put(key, map.getOrDefault(key, 0) + 1);

            // System.out.print(map.get(key) + " ");

            ans.append(map.get(key)).append(" ");

        }

        System.out.println(ans.toString());

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            a = in.next().toCharArray();

            solve();

        }

    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}
