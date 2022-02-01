import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B1_Rectangular_Game {

    static Scanner in = new Scanner(System.in);

    static int n;

    public static void main(String[] amit) {

        n = in.nextInt();

        List<Integer> divisor = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {

                divisor.add(i);

                if (n / i != i)
                    divisor.add(n / i);

            }

        }

        Collections.sort(divisor);

        int size = divisor.size();

        int dp[] = new int[size];

        dp[0] = 1;

        for (int i = 1; i < size; i++) {

            for (int j = 0; j < i; j++) {

                if (divisor.get(i) % divisor.get(j) == 0) {

                    dp[i] = Math.max(dp[i], dp[j]);

                }

            }

            dp[i] += divisor.get(i);

        }

        System.out.println(dp[size - 1]);

    }

}
