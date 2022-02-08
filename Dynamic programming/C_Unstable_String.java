import java.util.Scanner;

public class C_Unstable_String {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static char a[];

    static void solve() {

        int dp[][] = new int[n][2];// oth index for the count of the 0 and 1th index represent the count of the 1

        if (a[0] == '?')
            dp[0][0] = dp[0][1] = 1;// if the first index is '?' then we can guess it either 1 or 0
        else
            dp[0][a[0] - '0'] = 1;// other wise 1 or 0 we count as a substring

        long ans = Math.max(dp[0][0], dp[0][1]);// initial ans is the maximum of the dp's 0th and 1th index and every
                                                // time we update it as like as this way

        for (int i = 1; i < n; i++) {

            if (a[i] == '?') {// if the character is '?' so our answer can be increase from the 1 and also
                              // from the 0 so we have to increase from the both of the option

                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][0] + 1;

            } else {// other wise we increase the answer from the oposite site as 01 or 10

                dp[i][a[i] - '0'] = dp[i - 1][(a[i] - '0') == 0 ? 1 : 0] + 1;

            }

            ans += Math.max(dp[i][0], dp[i][1]);// every time increase the answer by collecting the maximum from the
                                                // both site

        }

        System.out.println(ans);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            a = in.next().toCharArray();

            n = a.length;

            solve();

        }

    }

}
/*
 * 
 * if we see this example then
 * 
 * ? 1 0 ? ? 1 1 0 0
 * 1 2 3 4 5 6 7 8 9
 * 1 0 3 1 5 0 0 2 1 :0
 * 1 2 0 4 2 6 1 0 0 :1
 * 1 3 6 10 15 21 22 24 25 :ans
 * 
 * so the number of substring is 25
 * 
 */
