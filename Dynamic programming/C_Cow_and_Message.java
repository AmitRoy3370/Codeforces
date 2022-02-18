import java.util.Scanner;

public class C_Cow_and_Message {

    static Scanner in = new Scanner(System.in);

    static int n;

    static char a[];

    static void solve() {

        long two_length_dp[][] = new long[26][26];

        long one_length_dp[] = new long[26];

        // for(char i: a) one_length_dp[i-'a' ]++;

        for (int i = 0; i < n; i++) {

            int present_character = a[i] - 'a';

            for (int j = 0; j < 26; j++) {

                two_length_dp[j][present_character] += one_length_dp[j];

                // one_length_dp[present_character]++;

            }

            one_length_dp[present_character]++;

        }

        long one_length = 0, two_length = 0;

        for (int i = 0; i < 26; i++)
            one_length = Math.max(one_length_dp[i], one_length);

        for (int i = 0; i < 26; i++) {

            for (int j = 0; j < 26; j++) {

                two_length = Math.max(two_length, two_length_dp[i][j]);

            }

        }

        System.out.print(Math.max(one_length, two_length));

    }

    public static void main(String[] amit) {

        a = in.next().toCharArray();

        n = a.length;

        solve();

    }

}
