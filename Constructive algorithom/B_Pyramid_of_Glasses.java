import java.util.Scanner;

public class B_Pyramid_of_Glasses {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] amit) {

        int height = in.nextInt();

        int time = in.nextInt();

        double dp[][] = new double[height + 2][height + 2];

        dp[1][1] += time;

        int ans = 0;

        for (int i = 1; i <= height; i++) {

            for (int j = 1; j <= i; j++) {

                if (dp[i][j] >= 1) {

                    dp[i + 1][j] += (dp[i][j] - 1) / 2;
                    dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
                    ans++;
                    // dp[i][j] = 1;

                }

            }

        }

        System.out.println(ans);

    }

}
