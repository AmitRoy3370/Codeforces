
import java.util.Scanner;

public class E_Triple_Operations {

    static Scanner in = new Scanner(System.in);

    static int testCases, l, r;

    static long dp[], devideDp[];

    static void init() {
        
        int N = (int)(2e5 + 10);
        
        dp = new long[N];
        devideDp = new long[N];
        
        for(int i = 1; i <= N - 1; ++i) {
            
            devideDp[i] = devideDp[i / 3] + 1;
            dp[i] = dp[i - 1] + devideDp[i];
            
        }

    }

    static void solve() {

        long operation = devideDp[l];
        operation += (dp[r] - dp[l - 1]);
        
        System.out.println(operation);
        
    }

    public static void main(String[] Priya) {

        testCases = in.nextInt();
        
        init();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        l = in.nextInt();
        r = in.nextInt();

    }

}
